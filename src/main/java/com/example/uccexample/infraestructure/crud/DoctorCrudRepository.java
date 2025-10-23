package com.example.uccexample.infraestructure.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.uccexample.infraestructure.model.Doctor;

public interface DoctorCrudRepository extends CrudRepository<Doctor,Long> {
    
}