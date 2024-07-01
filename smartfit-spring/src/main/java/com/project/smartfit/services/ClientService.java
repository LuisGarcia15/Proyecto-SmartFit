package com.project.smartfit.services;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;

public interface ClientService {

    Client registerOneRegister(SaveUser newUser);
}
