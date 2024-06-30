package com.project.smartfit.controllers;

import com.project.smartfit.entities.User;
import com.project.smartfit.services.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prueba")
public class Prueba {

    @Autowired
    private PruebaService service;

    @GetMapping("")
    public List<User> findAll(){
        return this.service.findAll();
    }
}
