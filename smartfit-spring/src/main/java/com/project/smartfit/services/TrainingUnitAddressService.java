package com.project.smartfit.services;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.TrainingUnitAddress;

public interface TrainingUnitAddressService {

    TrainingUnitAddress registerOneRegister(SaveUser newUser);
}
