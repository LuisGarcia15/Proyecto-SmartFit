package com.project.smartfit.dto;

/*Clase para hacer una petición de login*/
public class AuthenticationRequest {

    private String user;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
