package com.project.smartfit.repositories;

import com.project.smartfit.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface userRepository extends CrudRepository<User,Long> {

    List<User> findAll();

    Optional<User> findByUser(String user);
}
