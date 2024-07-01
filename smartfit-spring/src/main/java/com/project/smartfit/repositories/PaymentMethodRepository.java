package com.project.smartfit.repositories;

import com.project.smartfit.entities.PaymentMethod;
import org.springframework.data.repository.CrudRepository;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod,Long> {
}
