package com.example.uccexample.infraestructure.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historias_clinicas")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia")
    private Long idHistoria;

    private LocalDate fechaCreacion;
    private String grupoSanguineo;
    private String alergias;
    private String antecedentes;
    private String observaciones;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    public Long getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Long idHistoria) {
        this.idHistoria = idHistoria;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}