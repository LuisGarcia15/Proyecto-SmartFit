package com.project.smartfit.dto;

/*DTO que se encarga de transportar los datos para salvarse mediante
* una Entity en la BD. no incluye el rol pues solo existe un rol en
* la app*/
public class SaveUser {

    private String user;
    private String password;

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