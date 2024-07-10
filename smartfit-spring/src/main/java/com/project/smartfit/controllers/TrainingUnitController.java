package com.project.smartfit.controllers;

import com.project.smartfit.entities.TrainingUnit;
import com.project.smartfit.repositories.TrainingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingUnitController {

    @Autowired
    private TrainingUnitRepository trainingUnitRepository;

    @GetMapping
    public ResponseEntity<List<TrainingUnit>> findAllTrainingUnits(){
        List<TrainingUnit> allTrainingUnit = (List<TrainingUnit>) this.trainingUnitRepository.findAll();
        return ResponseEntity.ok(allTrainingUnit);
    }
}
