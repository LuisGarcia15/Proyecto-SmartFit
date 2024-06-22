package com.project.smartfit.services;

import com.project.smartfit.entities.Client;
import com.project.smartfit.repositories.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PruebaService {

    @Autowired
    private PruebaRepository repository;

    public Optional<Client> findById(){
        Optional<Client> client = this.repository.findById(1L);
        return client;
    }

    public List<Client> findAll(){
        return this.repository.findAll();
    }
}
