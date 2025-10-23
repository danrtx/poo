package com.example.uccexample.infraestructure.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.uccexample.infraestructure.model.Cita;

public interface CitaCrudRepository extends CrudRepository<Cita,Long> {
    
}