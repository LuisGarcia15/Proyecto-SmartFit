package com.project.smartfit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "plan_benefits")
public class PlanBenefits {

    @ManyToOne
    @JoinColumn(name = "id_plan_plb")
    private Long idPLan;
    @ManyToOne
    @JoinColumn(name = "id_benefits_plb")
    private Long idBenefits;
}
