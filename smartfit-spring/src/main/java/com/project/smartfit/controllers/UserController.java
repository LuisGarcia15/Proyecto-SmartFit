package com.project.smartfit.controllers;

import com.project.smartfit.dto.AuthenticationResponse;
import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.services.AuthenticationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerOne(@RequestBody SaveUser newUser){
        this.authenticationService.registeredUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
