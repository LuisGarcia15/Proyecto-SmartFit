package com.project.smartfit.services;

import com.project.smartfit.dto.AuthenticationRequest;
import com.project.smartfit.dto.AuthenticationResponse;
import com.project.smartfit.dto.RegisteredUser;
import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    /*Se encarga de inyectar la única implementación de userService*/
    @Autowired
    private UserService userService;

    /*Se encarga de intectar la clase de jwtService*/
    @Autowired
    private JwtService jwtService;

    @Autowired
    /*Inycta un objeto que implementa la interfaz AuthenticationManager
    * Objeto que e encargará del login en la aplicación*/
    private AuthenticationManager login;

    /*Permite registrar un usuario en la BD y usar un dto para el logn*/
    public RegisteredUser registeredUser(SaveUser newUser){
        /*Crea un nuevo User en la BD*/
        User user = userService.registerOneCustomer(newUser);

        /*Poblamos el dto con el nuevo usario creado*/
        RegisteredUser registeredUser = new RegisteredUser();
        registeredUser.setId(user.getId());
        registeredUser.setUser(user.getUser());
        registeredUser.setRole(user.getRole().name());

        /*PARA GENERAR EL TOKEN, SE NECESITA UNA ENTITY USER, PUES
        * ESTA IMPLEMENTA LA INTERFAZ UserDetails Y EL MÉTODO
        * generateToker(UserDetails) NECESITA COMO PARÁMETRO
        * UN UserDetails*/
        String token = jwtService.generateToken(user, generateExtraClaims(user));
        registeredUser.setToken(token);

        return registeredUser;
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
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUser(), authenticationRequest.getPassword()
        );
        /*Se realiza el proceso de Login. Recordemos que un AuthenticationManager tiene
        * el método authenticate() para realizar el login*/
        this.login.authenticate(authentication);
        /*Obtenemos los detalles del usuario que se avaba de logear de la BD*/
        UserDetails user = this.userService.findByUser(authenticationRequest.getUser()).get();
        /*Generamos el Token del user*/
        String jwt = this.jwtService.generateToken(user, generateExtraClaims((User) user));
        /*Genermaos el DTO de login*/
        AuthenticationResponse response = new AuthenticationResponse(jwt);
        return response;
    }

    public boolean validateToken(String jwt) {
        /*Validar que:
        * El formato del token es correcto, que su JSON es valido
        * La firma debe coincidir
        * La expiracion del token*/
        /*Extraeremos un claim para validar las tres cosas al mismo tiempo*/
        try {
            this.jwtService.extractUser(jwt);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
