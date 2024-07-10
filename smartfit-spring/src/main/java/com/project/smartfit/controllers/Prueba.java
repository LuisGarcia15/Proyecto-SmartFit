package com.project.smartfit.controllers;

import com.project.smartfit.entities.User;
import com.project.smartfit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prueba")
public class Prueba {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> findAllUser(){
        List<User> response = this.userRepository.findAll();
        return ResponseEntity.ok(response);
    }
}
