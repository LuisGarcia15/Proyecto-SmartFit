package com.project.smartfit.services;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;
import com.project.smartfit.entities.ClientAddress;

public interface ClientAddressService {

    ClientAddress registerOneRegister(SaveUser newUser, Client client);
}
