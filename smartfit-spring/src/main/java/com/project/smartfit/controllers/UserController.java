package com.project.smartfit.controllers;

import com.project.smartfit.dto.RegisteredUser;
import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisteredUser> registerOne(@RequestBody SaveUser newUser){
        RegisteredUser registeredUser = this.authenticationService.registeredUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
}
