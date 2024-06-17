package com.project.smartfit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    private Long id;
    private String name;
}
