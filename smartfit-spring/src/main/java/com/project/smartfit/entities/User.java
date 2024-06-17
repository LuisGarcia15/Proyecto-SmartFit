package com.project.smartfit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usr")
    private Long id;
    @Column(name = "role_usr")
    @NotNull
    private String role;
    @Column(name = "user_usr")
    @NotNull
    private String user;
    @Column(name = "password_usr")
    @NotNull
    private String password;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_client_usr")
    private Long idClient;

    public User() {
    }

    public User(Long id, String role, String user, String password, Long idClient) {
        this.id = id;
        this.role = role;
        this.user = user;
        this.password = password;
        this.idClient = idClient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getRole() {
        return role;
    }

    public void setRole(@NotNull String role) {
        this.role = role;
    }

    public @NotNull String getUser() {
        return user;
    }

    public void setUser(@NotNull String user) {
        this.user = user;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(id, user1.id) && Objects.equals(role, user1.role) && Objects.equals(user, user1.user) && Objects.equals(password, user1.password) && Objects.equals(idClient, user1.idClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, user, password, idClient);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", idClient=" + idClient +
                '}';
    }
}
