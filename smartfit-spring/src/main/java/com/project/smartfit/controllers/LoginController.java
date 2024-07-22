package com.project.smartfit.controllers;

import com.project.smartfit.dto.AuthenticationRequest;
import com.project.smartfit.dto.AuthenticationResponse;
import com.project.smartfit.repositories.ClientRepository;
import com.project.smartfit.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
//@CrossOrigin
/*CrossOrigin sin parametros permite cualquier peticion de cualquier origen.
* A nivel de clase admite peticiones a todos los métodos. A nivel de método
* solo aceptamos en ese método.
* El parámetro origins permite ingresar como string una URL o un array de
* Strins URL que son los origenes que acepta*/
@RestController
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/logout")//Se recomienda que los métodos logout
    //sean POST aún no nos devuelvan nada
    public ResponseEntity<?> logout(HttpServletRequest request){
        authenticationService.logout(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest authenticationRequest) {
        /*EL OBJETO AUTHENTIONREQUEST SE POBLA DE DATOS CON LA INFORMARCIÓN QUE VIENE EN
         * EL BODY DE LA PETICIÓN*/
        AuthenticationResponse response = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/token")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt) {
        /*Valida que el JWT que le pasamos como parámetro tenga la firma correcta
         * con la clave original. Si es así devuelve true, de lo contrario, si la firma
         * no coincide con la clave original, se devuelve false*/
        boolean isTokenValid = authenticationService.validateToken(jwt);
        return ResponseEntity.ok(isTokenValid);
    }

}