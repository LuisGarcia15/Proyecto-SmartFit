package com.project.smartfit.services;

import com.project.smartfit.entities.User;
import com.project.smartfit.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaService {

    @Autowired
    private userRepository repository;

    public List<User> findAll(){
        return this.repository.findAll();
    }
}
