package com.project.smartfit.repositories;

import com.project.smartfit.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PruebaRepository extends CrudRepository<Client, Long> {

    List<Client> findAll();
    Optional<Client> findById(Long id);
}
