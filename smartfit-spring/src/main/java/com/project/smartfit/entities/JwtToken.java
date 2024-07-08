package com.project.smartfit.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "jwt_token")
public class JwtToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tkn")
    private Long id;

    /*Atributo que contiene el JWT de un usuario logueado*/
    @Column(length = 2048, name = "token_tkn")
    private String jwt;

    @Column(name = "date_expiration_tkn")
    private Date expiration;

    @Column(name = "is_valid_tkn")
    private boolean isValid;

    @OneToOne
    @JoinColumn(name = "id_user_tkn")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
