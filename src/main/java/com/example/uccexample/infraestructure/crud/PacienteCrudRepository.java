package com.example.uccexample.infraestructure.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.uccexample.infraestructure.model.Paciente;

public interface PacienteCrudRepository extends CrudRepository<Paciente,Long> {
    
}