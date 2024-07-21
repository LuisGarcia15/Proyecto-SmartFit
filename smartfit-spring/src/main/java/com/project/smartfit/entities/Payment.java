package com.project.smartfit.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pyt")
    @NotNull
    private Long id;
    @Column(name = "payment_description_pyt")
    @NotNull
    private String paymentDescription;
    @Column(name = "due_date_pyt")
    @NotNull
    private String dueDate;
    @Column(name = "start_date_pyt")
    @NotNull
    private String startDate;
    @Column(name = "end_date_pyt")
    @NotNull
    private String endDate;
    @Column(name = "total_balance_pyt")
    @NotNull
    private Double totalBalance;
    @Column(name = "flag_pmd")
    private String flag;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_client_pyt")
    @NotNull
    @JsonBackReference
    private Client idClient;

    public Payment() {
    }

    public Payment(Long id, String paymentDescription, String dueDate, String startDate, String endDate, Double totalBalance, String flag, Client idClient) {
        this.id = id;
        this.paymentDescription = paymentDescription;
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBalance = totalBalance;
        this.flag = flag;
        this.idClient = idClient;
    }

    public @NotNull Long getId() {
        return id;
    }

    public void setId(@NotNull Long id) {
        this.id = id;
    }

    public @NotNull String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(@NotNull String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public @NotNull String getDueDate() {
        return dueDate;
    }

    public void setDueDate(@NotNull String dueDate) {
        this.dueDate = dueDate;
    }

    public @NotNull String getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotNull String startDate) {
        this.startDate = startDate;
    }

    public @NotNull String getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotNull String endDate) {
        this.endDate = endDate;
    }

    public @NotNull Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(@NotNull Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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
        if (!(o instanceof Payment payment)) return false;
        return Objects.equals(id, payment.id) && Objects.equals(paymentDescription, payment.paymentDescription) && Objects.equals(dueDate, payment.dueDate) && Objects.equals(startDate, payment.startDate) && Objects.equals(endDate, payment.endDate) && Objects.equals(totalBalance, payment.totalBalance) && Objects.equals(flag, payment.flag) && Objects.equals(idClient, payment.idClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentDescription, dueDate, startDate, endDate, totalBalance, flag, idClient);
    }

    @Override
    public String toString() {
        return "{" +
                "flag='" + flag + '\'' +
                ", totalBalance=" + totalBalance +
                ", endDate='" + endDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", paymentDescription='" + paymentDescription + '\'' +
                ", id=" + id +
                '}';
    }
}
