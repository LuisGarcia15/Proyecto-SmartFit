package com.project.smartfit.services;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.TrainingUnit;

public interface TrainingUnitService {

    TrainingUnit registerOneRegister(SaveUser newUser);
}
