package com.project.smartfit.controllers;

import com.project.smartfit.entities.Plan;
import com.project.smartfit.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    @GetMapping("/plan")
    public ResponseEntity<List<Plan>> findAllTrainingUnits(){
        List<Plan> allPlans = (List<Plan>) this.planRepository.findAll();
        System.out.println(allPlans);
        return ResponseEntity.ok(allPlans);
    }
}
