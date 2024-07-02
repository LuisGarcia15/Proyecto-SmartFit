package com.project.smartfit.repositories;

import com.project.smartfit.entities.Plan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlanRepository extends CrudRepository<Plan,Long> {

    Optional<Plan> findById(Long id);
}
