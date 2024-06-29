package com.project.smartfit.services;

import com.project.smartfit.entities.User;
import com.project.smartfit.dto.SaveUser;

/*Interface de User, define los contratos del servicio*/
public interface UserService {
    User registerOneCustomer(SaveUser newUser);
}
