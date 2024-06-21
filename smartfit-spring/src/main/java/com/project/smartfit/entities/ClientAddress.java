package com.project.smartfit.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "client_address")
public class ClientAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cls")
    private Long id;
    @Column(name = "name_cls")
    @NotNull
    private String name;
    @Column(name = "outer_number_cls")
    @NotNull
    private String outerNumber;
    @Column(name = "inside_number_cls")
    @NotNull
    private String insideNumber;
    @Column(name = "state_cls")
    @NotNull
    private String state;
    @Column(name = "city_cls")
    @NotNull
    private String city;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_client_cls")
    @NotNull
    private Client idClient;

    public ClientAddress() {
    }

    public ClientAddress(Long id, String name, String outerNumber, String insideNumber, String state, String city, Client idClient) {
        this.id = id;
        this.name = name;
        this.outerNumber = outerNumber;
        this.insideNumber = insideNumber;
        this.state = state;
        this.city = city;
        this.idClient = idClient;
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

    public @NotNull String getOuterNumber() {
        return outerNumber;
    }

    public void setOuterNumber(@NotNull String outerNumber) {
        this.outerNumber = outerNumber;
    }

    public @NotNull String getInsideNumber() {
        return insideNumber;
    }

    public void setInsideNumber(@NotNull String insideNumber) {
        this.insideNumber = insideNumber;
    }

    public @NotNull String getState() {
        return state;
    }

    public void setState(@NotNull String state) {
        this.state = state;
    }

    public @NotNull String getCity() {
        return city;
    }

    public void setCity(@NotNull String city) {
        this.city = city;
    }

    public @NotNull Client getIdClient() {
        return idClient;
    }

    public void setIdClient(@NotNull Client idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientAddress that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(outerNumber, that.outerNumber) && Objects.equals(insideNumber, that.insideNumber) && Objects.equals(state, that.state) && Objects.equals(city, that.city) && Objects.equals(idClient, that.idClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, outerNumber, insideNumber, state, city, idClient);
    }

    @Override
    public String toString() {
        return "ClientAddress{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", outerNumber='" + outerNumber + '\'' +
                ", insideNumber='" + insideNumber + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", idClient=" + idClient +
                '}';
    }
}
