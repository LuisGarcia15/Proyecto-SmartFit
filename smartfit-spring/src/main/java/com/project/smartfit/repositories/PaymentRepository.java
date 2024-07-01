package com.project.smartfit.repositories;

import com.project.smartfit.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Long> {
}
