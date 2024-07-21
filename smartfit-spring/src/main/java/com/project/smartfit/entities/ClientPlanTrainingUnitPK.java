package com.project.smartfit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ClientPlanTrainingUnitPK {

    @Column(name = "id_client_cpl")
    private Long idClient;
    @Column(name = "start_date_cpl")
    private String startDate;


    public ClientPlanTrainingUnitPK() {
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientPlanTrainingUnitPK that)) return false;
        return Objects.equals(idClient, that.idClient) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, startDate);
    }

    @Override
    public String toString() {
        return "ClientPlanTrainingUnitPK{" +
                "idClient=" + idClient +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
