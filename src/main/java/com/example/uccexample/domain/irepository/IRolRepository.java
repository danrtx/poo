package com.example.uccexample.domain.irepository;

import com.example.uccexample.infraestructure.model.Rol;
import com.example.uccexample.infraestructure.model.Rol.RolNombre;

import java.util.Optional;

public interface IRolRepository {
    Optional<Rol> findByNombre(RolNombre nombre);
    Rol save(Rol rol);
}