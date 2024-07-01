package com.project.smartfit.services;

import com.project.smartfit.entities.User;
import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;

import java.util.Optional;

/*Interface de User, define los contratos del servicio*/
public interface UserService {
    User registerOneCustomer(SaveUser newUser, Client client);

    Optional<User> findByUser(String user);
}
