package com.project.smartfit.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    /*Método que se encargara de generar el token*/
    public String generateToken(UserDetails user){
        return null;
    }
}
