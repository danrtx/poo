package com.example.uccexample.infraestructure.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.uccexample.infraestructure.model.Tratamiento;

public interface TratamientoCrudRepository extends CrudRepository<Tratamiento,Long> {
    
}