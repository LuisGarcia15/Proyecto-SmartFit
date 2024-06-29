package com.project.smartfit.implementations;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.User;
import com.project.smartfit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.smartfit.repositories.userRepository;

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
    public User registerOneCustomer(SaveUser newUser) {
    /*Se encarga de persistir un usuario en la BD*/
        User user = new User();
        user.setUser(newUser.getUser());
        /*Se encripta la contraseña para no guardarla en bruto en la BD*/
        user.setPassword(this.passwordEncoder.encode(newUser.getPassword()));
        user.setRole("CUSTOMER");

        return this.userRepository.save(user);
    }
}