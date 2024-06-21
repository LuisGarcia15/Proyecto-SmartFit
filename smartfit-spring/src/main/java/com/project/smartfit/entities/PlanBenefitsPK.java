package com.project.smartfit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class PlanBenefitsPK {

    @Column(name = "id_plan_plb")
    private Long idPLan;
    @Column(name = "id_benefits_plb")
    private Long idBenefits;

    public PlanBenefitsPK() {
    }

    public Long getIdPLan() {
        return idPLan;
    }

    public void setIdPLan(Long idPLan) {
        this.idPLan = idPLan;
    }

    public Long getIdBenefits() {
        return idBenefits;
    }

    public void setIdBenefits(Long idBenefits) {
        this.idBenefits = idBenefits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanBenefitsPK that)) return false;
        return Objects.equals(idPLan, that.idPLan) && Objects.equals(idBenefits, that.idBenefits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPLan, idBenefits);
    }

    @Override
    public String toString() {
        return "PlanBenefitsPK{" +
                "idPLan=" + idPLan +
                ", idBenefits=" + idBenefits +
                '}';
    }
}
