package com.project.smartfit.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "client_plan_training_unit")
public class ClientPlanTrainingUnit {

    @EmbeddedId
    private ClientPlanTrainingUnitPK id;
    @OneToOne
    @JoinColumn(name = "id_plan_cpl")
    private Plan idPlan;
    @OneToOne
    @JoinColumn(name = "id_training_unit_cpl")
    private TrainingUnit idTrainingUnit;

    public ClientPlanTrainingUnit() {
    }

    public ClientPlanTrainingUnitPK getId() {
        return id;
    }

    public void setId(ClientPlanTrainingUnitPK id) {
        this.id = id;
    }

    public Plan getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Plan idPlan) {
        this.idPlan = idPlan;
    }

    public TrainingUnit getIdTrainingUnit() {
        return idTrainingUnit;
    }

    public void setIdTrainingUnit(TrainingUnit idTrainingUnit) {
        this.idTrainingUnit = idTrainingUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientPlanTrainingUnit that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(idPlan, that.idPlan) && Objects.equals(idTrainingUnit, that.idTrainingUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPlan, idTrainingUnit);
    }

    @Override
    public String toString() {
        return "ClientPlanTrainingUnit{" +
                "id=" + id +
                ", idPlan=" + idPlan +
                ", idTrainingUnit=" + idTrainingUnit +
                '}';
    }
}
