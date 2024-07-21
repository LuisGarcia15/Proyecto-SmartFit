package com.project.smartfit.entities;

import com.project.smartfit.util.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
/*UserDetails
* Es una representación de encapsular la información de un usuario que sera
* envuelto por un objeto Authentication.
* Es una interfaz que define un contrato para representar la información
* del usuario que Spring Security necesita para la autenticación y autorización
* y que sera parte de un objeto Authentication*/
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usr")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_usr")
    @NotNull
    private Role role;
    @Column(name = "user_usr", unique = true)
    @NotNull
    private String user;
    @Column(name = "password_usr")
    @NotNull
    private String password;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_client_usr")
    @NotNull
    private Client idClient;

    public User() {
    }

    public User(Long id, Role role, String user, String password, Client idClient) {
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

    public @NotNull Role getRole() {
        return role;
    }

    public void setRole(@NotNull Role role) {
        this.role = role;
    }

    public @NotNull String getUser() {
        return user;
    }

    public void setUser(@NotNull String user) {
        this.user = user;
    }

    public @NotNull Client getIdClient() {
        return idClient;
    }

    public void setIdClient(@NotNull Client idClient) {
        this.idClient = idClient;
    }

    /*Mapea los permisos del rol a objetos GrantedAuthority, para crear listas
    * de objetos GrantedAuthority*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(role == null) return null;

        if(role.getPermisions() == null) return null;

        /*Cada enumeración de rol tiene un nombre, para pasarle ese nombre
         * de ese rol a la implemetación de GrantedAuthority,obtenemos el nombre
         * y se lo pasamos a una instancia de la implementación*/
        return role.getPermisions().stream().map(each -> {
            String permission = each.name();
            /*Un SimpleGrantedAuthority es la implemetación de un GrantedAuthority,
             * y necesita como argumento de su creación, el nombre del ROL*/
            return new SimpleGrantedAuthority(permission);
            /*Contruimos los roles como una coleción de implementaciones
             * de GrantedAuthority*/
        }).collect(Collectors.toList());
    }

    public @NotNull String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.user;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
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
        return "{" +
                "id=" + id +
                ", role=" + role +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
