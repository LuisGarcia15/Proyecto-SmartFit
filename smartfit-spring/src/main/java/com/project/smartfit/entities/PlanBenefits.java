package com.project.smartfit.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "plan_benefits")
public class PlanBenefits {

    @EmbeddedId
    private PlanBenefitsPK id;

    public PlanBenefits() {
    }

    public PlanBenefitsPK getId() {
        return id;
    }

    public void setId(PlanBenefitsPK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanBenefits that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                "}\n";
    }
}
