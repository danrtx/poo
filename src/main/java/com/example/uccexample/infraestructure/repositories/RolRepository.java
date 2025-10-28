package com.example.uccexample.infraestructure.repositories;

import com.example.uccexample.domain.irepository.IRolRepository;
import com.example.uccexample.infraestructure.crud.RolCrudRepository;
import com.example.uccexample.infraestructure.model.Rol;
import com.example.uccexample.infraestructure.model.Rol.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RolRepository implements IRolRepository {

    @Autowired
    private RolCrudRepository rolCrudRepository;

    @Override
    public Optional<Rol> findByNombre(RolNombre nombre) {
        return rolCrudRepository.findByNombre(nombre);
    }

    @Override
    public Rol save(Rol rol) {
        return rolCrudRepository.save(rol);
    }
}