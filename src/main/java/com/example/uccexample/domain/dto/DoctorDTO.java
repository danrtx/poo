package com.example.uccexample.domain.dto;

public class DoctorDTO {
    
    private Long idDoctor;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String licenciaMedica;
    private String telefono;
    private String email;

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLicenciaMedica() {
        return licenciaMedica;
    }

    public void setLicenciaMedica(String licenciaMedica) {
        this.licenciaMedica = licenciaMedica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}