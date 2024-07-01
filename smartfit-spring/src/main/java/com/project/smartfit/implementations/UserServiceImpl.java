package com.project.smartfit.implementations;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;
import com.project.smartfit.entities.User;
import com.project.smartfit.repositories.userRepository;
import com.project.smartfit.services.UserService;
import com.project.smartfit.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*Clase que implementa el UserService para incluir su propia lógica*/
@Service
public class UserServiceImpl implements UserService {

    /*Inyecta el repositorio de user*/
    @Autowired
    private userRepository userRepository;

    /*Inyecta el bean que implemente el PasswordEncoder*/
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerOneCustomer(SaveUser newUser, Client client) {
    /*Se encarga de persistir un usuario en la BD*/
        User user = new User();
        user.setIdClient(client);
        user.setUser(newUser.getUser());
        /*Se encripta la contraseña para no guardarla en bruto en la BD*/
        user.setPassword(this.passwordEncoder.encode(newUser.getPassword()));
        user.setRole(Role.ROLE_CUSTOMER);

        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> findByUser(String user) {
        return this.userRepository.findByUser(user);
    }
}
