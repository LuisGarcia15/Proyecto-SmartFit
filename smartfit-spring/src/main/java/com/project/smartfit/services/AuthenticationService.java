package com.project.smartfit.services;

import com.project.smartfit.dto.RegisteredUser;
import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
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
}
