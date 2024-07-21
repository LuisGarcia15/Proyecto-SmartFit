package com.project.smartfit.services;

import com.project.smartfit.dto.AuthenticationRequest;
import com.project.smartfit.dto.AuthenticationResponse;
import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.*;
import com.project.smartfit.repositories.JwtTokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationService {

    /*Se encarga de inyectar la única implementación de userService*/
    @Autowired
    private UserService userService;

    @Autowired
    private ClientAddressService clientAddressServiceService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ContactPersonService contactPersonService;
    @Autowired
    private PaymentMethodService paymentMethodService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ClientPlanTrainingUnitService clientPlanTrainingUnitService;

    /*Se encarga de intectar la clase de jwtService*/
    @Autowired
    private JwtService jwtService;

    /*Encargado de inyectar el repositorio para obtener un JWT*/
    @Autowired
    private JwtTokenRepository jwtRepository;

    @Autowired
    /*Inycta un objeto que implementa la interfaz AuthenticationManager
    * Objeto que e encargará del login en la aplicación. Sera ProviderManager*/
    private AuthenticationManager authenticationManager;

    /*Permite registrar un usuario en la BD y usar un dto para el logn*/
    public AuthenticationResponse registeredUser(SaveUser newUser){
        /*Crea un nuevo User en la BD, LOS SIGUIENTES MÉTODOS REGISTRAN
        * LA INFORMACIÓN DE UN NUEVO USUARIO EN LA BD*/
        Client client = this.clientService.registerOneRegister(newUser);
        User user = userService.registerOneCustomer(newUser, client);
        ClientAddress clientAddress = this.clientAddressServiceService.registerOneRegister(newUser, client);
        ContactPerson contactPerson = this.contactPersonService.registerOneRegister(newUser, client);
        PaymentMethod paymentMethod = this.paymentMethodService.registerOneRegister(newUser, client);
        Payment payment = this.paymentService.registerOneRegister(newUser, client);
        ClientPlanTrainingUnit clientPlanTrainingUnit = this.clientPlanTrainingUnitService
                .registerOneRegister(newUser, client);

        /*PARA GENERAR EL TOKEN, SE NECESITA UNA ENTITY USER, PUES
         * ESTA IMPLEMENTA LA INTERFAZ UserDetails Y EL MÉTODO
         * generateToker(UserDetails) NECESITA COMO PARÁMETRO
         * UN UserDetails*/
        String token = jwtService.generateJWT(user, generateExtraClaims(user));

        /*Salvamos el JWT en la BD*/
        //saveUserToken(user, token);

        /*Poblamos el dto con el nuevo usuario creado, esta clase nos sirve para mostrar el JWT
        * formado para un nuevo usuario*/
//        RegisteredUser registeredUser = new RegisteredUser();
//        registeredUser.setId(user.getId());
//        registeredUser.setUser(user.getUser());
//        registeredUser.setRole(user.getRole().name());
//        registeredUser.setToken(token);

        AuthenticationRequest authenticationRequest = new AuthenticationRequest(newUser.getUser(), newUser.getPassword());
        return this.login(authenticationRequest);
    }

    private void saveUserToken(User user, String jwt) {
        JwtToken token = new JwtToken();

        token.setJwt(jwt);
        token.setUser(user);
        token.setExpiration(this.jwtService.extractExpiration(jwt));
        token.setValid(true);

        this.jwtRepository.save(token);
    }

    private Map<String, Object> generateExtraClaims(User user) {
        /*Genera los extraclaims no necesarios que se pueden añadir al paylot del JWT*/
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("user", user.getUser());
        extraClaims.put("role", user.getRole());
        extraClaims.put("authorities", user.getAuthorities());

        return extraClaims;
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        /*ESTE MÉTODO AUTENTICA UN USUARIO, PERO NO COLOCA EL OBJETO AUTHENTICATION EN EL
        * SECURITYCONTEXTHOLDER, YA QUE ESTE MÉTODO SOLO SE ENCARGA DE AUTENTICAR
        *
        * COLOCAR EL AUTHENTICATION EN EL SECURITYCONTEXTHOLDER SERA EL ENCARGADO
        * JWTAUTHORIZATIONFILTER*/
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUser(), authenticationRequest.getPassword()
        );
        /*Se realiza el proceso de Login. Recordemos que un AuthenticationManager tiene
        * el método authenticate() para realizar el login*/
        this.authenticationManager.authenticate(authentication);
        /*Obtenemos los detalles del usuario que se avaba de logear de la BD*/
        UserDetails user = this.userService.findByUser(authenticationRequest.getUser()).get();
        /*Generamos el Token del user unicmante para devolverlo, NO LO NECESITA EL MÉTODO AUTHENTICATE
        * COMO PARÁMETRO, este método es el encargado de realizar el login*/
        String jwt = this.jwtService.generateJWT(user, generateExtraClaims((User) user));
        /*Salvamos el JWT en la BD*/
        saveUserToken((User) user, jwt);
        /*Genermaos el DTO de login*/
        AuthenticationResponse response = new AuthenticationResponse(jwt);
        return response;
    }

    /*MÉTODO DE VALIDACIÓN DE TOKEN*/
    public boolean validateToken(String jwt) {
        /*Validar que:
        * El formato del token es correcto, que su JSON es valido
        * La firma debe coincidir
        * La expiracion del token*/
        /*Extraeremos un claim para validar las tres cosas al mismo tiempo*/
        try {
            this.jwtService.extractSubject(jwt);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public User findLogguedUser() {
        /*Obtenemos el usuario logueado del SpringSecurityCotnext, como
        * el usuario se encuentra en un objeto Authentication, obtenemos
        * el usuario loggueado en un objero Authentication*/
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        /*Si auth es una implementación de Authenticathion de la clase
        * UsernamePasswordAuthenticathionToken, se parcea la variable
        * auth a authToken solo que ahora es de la clase
        * UsernamePassswordAuthnticationToken.
        *
        * Esto es así ya que en el JwtAuthenticationFilter, colocamos
        * un objeto de tipo UsernamePassworsAuthenticationFilter como
        * objeto Authorization en el SecurityContextHolder
        *
        * El if NO es necesario, puesto que solo estamos manjando un
        * tipo de autenticación el cual es DoAuthenticationProvider
        * pero es una manera de ejemplificar como se trabajaría para
        * un sistema con más autenticaciones*/
        if(auth instanceof UsernamePasswordAuthenticationToken authToken){
            String username = (String) authToken.getPrincipal();

            return userService.findByUser(username).orElseThrow();
        }
        return null;
    }

    public void logout(HttpServletRequest request) {
        /*Obtenemos el JWT de una petición*/
        String jwt = this.jwtService.extractJwtFromRequest(request);
        /*Si el jwt es nulo o vacio, entonces devolvemos el control
        * al método que llamo a este método*/
        if(jwt == null || jwt.isEmpty()){
            return;
        }
        /*Si existe un JWT, buscamos ese JWT en la base de datos*/
        Optional<JwtToken> token = this.jwtRepository.findByJwt(jwt);

        /*Si existe un objeto en el Opcional y es valido el token*/
        if(token.isPresent() && token.get().isValid()){
            token.get().setValid(false);
            /*Colocamos su validez en falso*/
            this.jwtRepository.save(token.get());
            /*Actualizamos ese token en la BD*/
        }
    }
}
