package com.project.smartfit.controllers;

import com.project.smartfit.entities.Client;
import com.project.smartfit.repositories.ClientRepository;
import com.project.smartfit.repositories.UserRepository;
import com.project.smartfit.services.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProfileController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/profile")
    public ResponseEntity<Client> findOneProfile(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization").split(" ")[1];
        String user = this.jwtService.extractSubject(jwt);
        Client client = this.userRepository.findUserAndClient(user).orElseThrow().getIdClient();
        return ResponseEntity.ok(client);
    }
}
