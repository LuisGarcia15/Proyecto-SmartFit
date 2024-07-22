package com.project.smartfit.repositories;

import com.project.smartfit.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUser(String user);

    @Query(value = "select u from User u join fetch u.idClient where u.user = ?1")
    Optional<User> findUserAndClient(String user);
}
