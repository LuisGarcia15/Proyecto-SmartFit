package com.project.smartfit.controllers;

import com.project.smartfit.dto.AuthenticationRequest;
import com.project.smartfit.dto.AuthenticationResponse;
import com.project.smartfit.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/token")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt){
        boolean isTokenValid = authenticationService.validateToken(jwt);
        return ResponseEntity.ok(isTokenValid);
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest authenticationRequest){
            AuthenticationResponse response = authenticationService.login(authenticationRequest);
            return ResponseEntity.ok(response);
    }
}
