package com.project.smartfit.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pmd")
    private Long id;
    @Column(name = "full_name_pmd")
    @NotNull
    private String fullName;
    @Column(name = "number_card_pmd")
    @NotNull
    private String numberCard;
    @Column(name = "number_cvc_pmd")
    @NotNull
    private String numberCVC;
    @Column(name = "date_card_pmd")
    @NotNull
    private String dateCard;
    @Column(name = "flag_pmd")
    @NotNull
    private String flag;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_client_pmd")
    @NotNull
    private Long idClient;

    public PaymentMethod() {
    }

    public PaymentMethod(Long id, String fullName, String numberCard, String numberCVC, String dateCard, String flag, Long idClient) {
        this.id = id;
        this.fullName = fullName;
        this.numberCard = numberCard;
        this.numberCVC = numberCVC;
        this.dateCard = dateCard;
        this.flag = flag;
        this.idClient = idClient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getFullName() {
        return fullName;
    }

    public void setFullName(@NotNull String fullName) {
        this.fullName = fullName;
    }

    public @NotNull String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(@NotNull String numberCard) {
        this.numberCard = numberCard;
    }

    public @NotNull String getNumberCVC() {
        return numberCVC;
    }

    public void setNumberCVC(@NotNull String numberCVC) {
        this.numberCVC = numberCVC;
    }

    public @NotNull String getDateCard() {
        return dateCard;
    }

    public void setDateCard(@NotNull String dateCard) {
        this.dateCard = dateCard;
    }

    public @NotNull String getFlag() {
        return flag;
    }

    public void setFlag(@NotNull String flag) {
        this.flag = flag;
    }

    public @NotNull Long getIdClient() {
        return idClient;
    }

    public void setIdClient(@NotNull Long idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethod that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(numberCard, that.numberCard) && Objects.equals(numberCVC, that.numberCVC) && Objects.equals(dateCard, that.dateCard) && Objects.equals(flag, that.flag) && Objects.equals(idClient, that.idClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, numberCard, numberCVC, dateCard, flag, idClient);
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", numberCard='" + numberCard + '\'' +
                ", numberCVC='" + numberCVC + '\'' +
                ", dateCard='" + dateCard + '\'' +
                ", flag='" + flag + '\'' +
                ", idClient=" + idClient +
                '}';
    }
}
