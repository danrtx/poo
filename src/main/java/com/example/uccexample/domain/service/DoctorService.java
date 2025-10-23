package com.example.uccexample.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uccexample.domain.dto.DoctorDTO;
import com.example.uccexample.infraestructure.repositories.DoctorRepository;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorDTO> obtenerTodo(){
        return doctorRepository.getAll();
    }

    public DoctorDTO guardar(DoctorDTO doctorDTO){
        return doctorRepository.save(doctorDTO);
    }
}