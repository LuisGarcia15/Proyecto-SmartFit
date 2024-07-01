package com.project.smartfit.services;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;
import com.project.smartfit.entities.Payment;

public interface PaymentService {

    Payment registerOneRegister(SaveUser newUser, Client client);
}
