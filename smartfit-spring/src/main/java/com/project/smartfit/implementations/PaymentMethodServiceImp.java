package com.project.smartfit.implementations;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;
import com.project.smartfit.entities.PaymentMethod;
import com.project.smartfit.repositories.PaymentMethodRepository;
import com.project.smartfit.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImp implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod registerOneRegister(SaveUser newUser, Client client) {
        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setIdClient(client);
        paymentMethod.setFullName(newUser.getPaymentMethod().getFullName());
        paymentMethod.setNumberCard(newUser.getPaymentMethod().getNumberCard());
        paymentMethod.setNumberCVC(newUser.getPaymentMethod().getNumberCVC());
        paymentMethod.setDateCard(newUser.getPaymentMethod().getDateCard());
        paymentMethod.setFlag(newUser.getPaymentMethod().getFlag());

        return this.paymentMethodRepository.save(paymentMethod);
    }
}
