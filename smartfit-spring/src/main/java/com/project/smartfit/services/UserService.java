package com.project.smartfit.services;

import com.project.smartfit.entities.User;
import com.project.smartfit.dto.SaveUser;

import java.util.Optional;

/*Interface de User, define los contratos del servicio*/
public interface UserService {
    User registerOneCustomer(SaveUser newUser);

    Optional<User> findByUser(String user);
}
