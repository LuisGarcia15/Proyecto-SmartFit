package com.project.smartfit.repositories;

import com.project.smartfit.entities.JwtToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JwtTokenRepository extends CrudRepository<JwtToken, Long> {

    /*Buscamos un JWT por el JWT*/
    Optional<JwtToken> findByJwt(String jwt);
}
