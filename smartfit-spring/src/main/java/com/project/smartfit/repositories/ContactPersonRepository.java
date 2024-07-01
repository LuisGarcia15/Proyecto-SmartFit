package com.project.smartfit.repositories;

import com.project.smartfit.entities.ContactPerson;
import org.springframework.data.repository.CrudRepository;

public interface ContactPersonRepository extends CrudRepository<ContactPerson,Long> {
}
