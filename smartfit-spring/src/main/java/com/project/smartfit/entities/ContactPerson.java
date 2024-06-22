package com.project.smartfit.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "contact_person")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cpn")
    private Long id;
    @Column(name = "name_cpn")
    @NotNull
    private String name;
    @Column(name = "paternal_surname_cpn")
    @NotNull
    private String paternalSurname;
    @Column(name = "maternal_surname_cpn")
    @NotNull
    private String maternalSurname;
    @Column(name = "phone_number_cpn")
    @NotNull
    private String phoneNumber;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_client_cpn")
    @NotNull
    private Client idClient;

    public ContactPerson() {
    }

    public ContactPerson(Long id, String name, String paternalSurname, String maternalSurname, String phoneNumber, Client idClient) {
        this.id = id;
        this.name = name;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
        this.phoneNumber = phoneNumber;
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

    public @NotNull String getPaternalSurname() {
        return paternalSurname;
    }

    public void setPaternalSurname(@NotNull String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    public @NotNull String getMaternalSurname() {
        return maternalSurname;
    }

    public void setMaternalSurname(@NotNull String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    public @NotNull String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        if (!(o instanceof ContactPerson that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(paternalSurname, that.paternalSurname) && Objects.equals(maternalSurname, that.maternalSurname) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(idClient, that.idClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, paternalSurname, maternalSurname, phoneNumber, idClient);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", paternalSurname='" + paternalSurname + '\'' +
                ", maternalSurname='" + maternalSurname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idClient=" + idClient +
                "}\n";
    }
}