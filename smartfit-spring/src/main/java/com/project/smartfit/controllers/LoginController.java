package com.project.smartfit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.smartfit.dto.AuthenticationRequest;
import com.project.smartfit.dto.AuthenticationResponse;
import com.project.smartfit.dto.LogOutResponse;
import com.project.smartfit.entities.Client;
import com.project.smartfit.repositories.ClientRepository;
import com.project.smartfit.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@CrossOrigin
/*CrossOrigin sin parametros permite cualquier peticion de cualquier origen.
* A nivel de clase admite peticiones a todos los métodos. A nivel de método
* solo aceptamos en ese método.
* El parámetro origins permite ingresar como string una URL o un array de
* Strins URL que son los origenes que acepta*/
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/logout")//Se recomienda que los métodos logout
    //sean POST aún no nos devuelvan nada
    public ResponseEntity<LogOutResponse> logout(HttpServletRequest request){
        authenticationService.logout(request);
        return ResponseEntity.ok(new LogOutResponse("LogOut exitoso"));
    }

    /*Aunque se obtiene un perfil de un usuario logueado actualmente,
     * no se coloca su ID en la URL o como parámetro pues será el usuario
     * logueado en ese momento*/
    @GetMapping("/profile")
    public ResponseEntity<Client> findOneProfile() {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<Client> client = this.clientRepository.getAllInformationOneClient(1L);
        System.out.println(client.orElseThrow());
        return ResponseEntity.ok(client.orElseThrow());
    }

    @GetMapping("/token")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt) {
        /*Valida que el JWT que le pasamos como parámetro tenga la firma correcta
         * con la clave original. Si es así devuelve true, de lo contrario, si la firma
         * no coincide con la clave original, se devuelve false*/
        boolean isTokenValid = authenticationService.validateToken(jwt);
        return ResponseEntity.ok(isTokenValid);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest authenticationRequest) {
        /*EL OBJETO AUTHENTIONREQUEST SE POBLA DE DATOS CON LA INFORMARCIÓN QUE VIENE EN
         * EL BODY DE LA PETICIÓN*/
        AuthenticationResponse response = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(response);
    }

}