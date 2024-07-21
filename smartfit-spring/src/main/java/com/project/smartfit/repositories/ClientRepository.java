package com.project.smartfit.repositories;

import com.project.smartfit.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client,Long> {

    @Query(value = "select c from Client c join fetch c.clientAddress join fetch c.payment join fetch c.contactPerson join fetch c.paymentMethod where c.id = ?1")
    Optional<Client> getAllInformationOneClient(Long id);
}
