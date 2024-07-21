package com.project.smartfit.implementations;

import com.project.smartfit.dto.SaveUser;
import com.project.smartfit.entities.*;
import com.project.smartfit.repositories.ClientPlanTrainingUnitRepository;
import com.project.smartfit.repositories.PlanRepository;
import com.project.smartfit.repositories.TrainingUnitRepository;
import com.project.smartfit.services.ClientPlanTrainingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientPlanTrainingUnitServiceImp implements ClientPlanTrainingUnitService {

    @Autowired
    private ClientPlanTrainingUnitRepository clientPlanTrainingUnitRepository;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private TrainingUnitRepository trainingUnitRepository;

    @Override
    public ClientPlanTrainingUnit registerOneRegister(SaveUser newUser, Client client) {
        ClientPlanTrainingUnit clientPlanTrainingUnit = new ClientPlanTrainingUnit();

        clientPlanTrainingUnit.setId(new ClientPlanTrainingUnitPK());
        clientPlanTrainingUnit.getId().setIdClient(client.getId());
        clientPlanTrainingUnit.getId().setStartDate(newUser.getClientPlanTrainingUnit().getStartDate());
        clientPlanTrainingUnit.setIdPlan(newUser.getClientPlanTrainingUnit().getPlanId());
        clientPlanTrainingUnit.setIdTrainingUnit(newUser.getClientPlanTrainingUnit().getTrainingUnitId());

        return this.clientPlanTrainingUnitRepository.save(clientPlanTrainingUnit);
    }

    public Plan getPlanById(Long id){
        Optional<Plan> plan = this.planRepository.findById(id);
        System.out.println(plan.get());
        return plan.get();
    }

    public TrainingUnit getTrainingUnitById(Long id){
        Optional<TrainingUnit> trainingUnit = this.trainingUnitRepository.findById(id);
        System.out.println(trainingUnit.get());
        return trainingUnit.get();
    }
}
