package com.project.smartfit.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "benefits")
public class Benefits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bns")
    private Long id;
    @Column(name = "name_bns")
    @NotNull
    private String name;

    public Benefits() {
    }

    public Benefits(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Benefits benefits)) return false;
        return Objects.equals(id, benefits.id) && Objects.equals(name, benefits.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Benefits{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
