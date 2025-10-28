package com.example.uccexample.infraestructure.crud;

import com.example.uccexample.infraestructure.model.Rol;
import com.example.uccexample.infraestructure.model.Rol.RolNombre;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolCrudRepository extends CrudRepository<Rol, Long> {
    Optional<Rol> findByNombre(RolNombre nombre);
}