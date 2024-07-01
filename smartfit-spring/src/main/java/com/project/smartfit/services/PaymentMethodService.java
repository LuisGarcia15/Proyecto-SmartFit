package com.project.smartfit.services;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;
import com.project.smartfit.entities.PaymentMethod;

public interface PaymentMethodService {

    PaymentMethod registerOneRegister(SaveUser newUser, Client client);
}
