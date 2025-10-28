package com.example.uccexample.infraestructure.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false, unique = true)
    private RolNombre nombre;
    
    public Rol() {
    }
    
    public Rol(RolNombre nombre) {
        this.nombre = nombre;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public RolNombre getNombre() {
        return nombre;
    }
    
    public void setNombre(RolNombre nombre) {
        this.nombre = nombre;
    }
    
    public enum RolNombre {
        ROLE_USER,
        ROLE_ADMIN,
        ROLE_DOCTOR
    }
}