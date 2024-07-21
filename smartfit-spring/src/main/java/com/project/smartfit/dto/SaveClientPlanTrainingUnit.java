package com.project.smartfit.dto;

import com.project.smartfit.entities.Plan;
import com.project.smartfit.entities.TrainingUnit;

public class SaveClientPlanTrainingUnit {

    private String startDate;
    private Plan planId;
    private TrainingUnit trainingUnitId;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Plan getPlanId() {
        return planId;
    }

    public void setPlanId(Plan planId) {
        this.planId = planId;
    }

    public TrainingUnit getTrainingUnitId() {
        return trainingUnitId;
    }

    public void setTrainingUnitId(TrainingUnit trainingUnitId) {
        this.trainingUnitId = trainingUnitId;
    }
}
