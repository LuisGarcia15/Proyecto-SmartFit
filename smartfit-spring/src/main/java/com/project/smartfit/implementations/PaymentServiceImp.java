package com.project.smartfit.implementations;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.Client;
import com.project.smartfit.entities.Payment;
import com.project.smartfit.repositories.PaymentRepository;
import com.project.smartfit.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment registerOneRegister(SaveUser newUser, Client client) {
        Payment payment = new Payment();

        payment.setIdClient(client);
        payment.setPaymentDescription(newUser.getPayment().getPaymentDescription());
        payment.setDueDate(newUser.getPayment().getDueDate());
        payment.setStartDate(newUser.getPayment().getStartDate());
        payment.setEndDate(newUser.getPayment().getEndDate());
        payment.setTotalBalance(newUser.getPayment().getTotalBalance());
        payment.setFlag(newUser.getPayment().getFlag());

        return this.paymentRepository.save(payment);
    }
}
