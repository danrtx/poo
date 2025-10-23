package com.example.uccexample.infraestructure.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.uccexample.infraestructure.model.HistoriaClinica;

public interface HistoriaClinicaCrudRepository extends CrudRepository<HistoriaClinica,Long> {
    
}