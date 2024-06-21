package com.project.smartfit.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "training_unit")
public class TrainingUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tu")
    private Long id;
    @Column(name = "name_place_tu")
    @NotNull
    private String name;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_training_unit_address")
    @NotNull
    private TrainingUnitAddress idTrainingUnitAddress;

    public TrainingUnit() {
    }

    public TrainingUnit(Long id, String name, TrainingUnitAddress idTrainingUnitAddress) {
        this.id = id;
        this.name = name;
        this.idTrainingUnitAddress = idTrainingUnitAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull TrainingUnitAddress getIdTrainingUnitAddress() {
        return idTrainingUnitAddress;
    }

    public void setIdTrainingUnitAddress(@NotNull TrainingUnitAddress idTrainingUnitAddress) {
        this.idTrainingUnitAddress = idTrainingUnitAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainingUnit that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(idTrainingUnitAddress, that.idTrainingUnitAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idTrainingUnitAddress);
    }

    @Override
    public String toString() {
        return "TrainingUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idTrainingUnitAddress=" + idTrainingUnitAddress +
                '}';
    }
}
