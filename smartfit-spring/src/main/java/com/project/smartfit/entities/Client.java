package com.project.smartfit.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clt")
    private Long id;
    @Column(name = "name_clt")
    @NotNull
    private String name;
    @Column(name = "paternal_surname_clt")
    @NotNull
    private String paternalSurname;
    @Column(name = "maternal_surname_clt")
    @NotNull
    private String maternalSurname;
    @Column(name = "curp_clt")
    @NotNull
    private String curp;
    @Column(name = "phone_number_clt")
    @NotNull
    private String phoneNumber;
    @Column(name = "email_clt")
    @NotNull
    @JsonBackReference
    private String email;

    @JsonManagedReference
    @OneToOne(mappedBy = "idClient")
    private ClientAddress clientAddress;

    @JsonManagedReference
    @OneToOne(mappedBy = "idClient")
    private Payment payment;

    @JsonManagedReference
    @OneToOne(mappedBy = "idClient")
    private ContactPerson contactPerson;

    @JsonManagedReference
    @OneToOne(mappedBy = "idClient")
    private PaymentMethod paymentMethod;

    public Client() {
    }

    public Client(Long id, String name, String paternalSurname, String maternalSurname, String curp, String phoneNumber, String email) {
        this();
        this.id = id;
        this.name = name;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
        this.curp = curp;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public @NotNull String getCurp() {
        return curp;
    }

    public void setCurp(@NotNull String curp) {
        this.curp = curp;
    }

    public @NotNull String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(paternalSurname, client.paternalSurname) && Objects.equals(maternalSurname, client.maternalSurname) && Objects.equals(curp, client.curp) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, paternalSurname, maternalSurname, curp, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", paternalSurname='" + paternalSurname + '\'' +
                ", maternalSurname='" + maternalSurname + '\'' +
                ", curp='" + curp + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + "\n" +
                "ClientAddress=" + clientAddress + "\n" +
                "Payment=" + payment + "\n" +
                "ContactPerson=" + contactPerson + "\n" +
                "PaymentMethod=" + paymentMethod + "\n" +
                '}';
    }
}
