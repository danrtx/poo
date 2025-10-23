package com.example.uccexample.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uccexample.domain.dto.CitaDTO;
import com.example.uccexample.infraestructure.repositories.CitaRepository;

@Service
public class CitaService {
    
    @Autowired
    private CitaRepository citaRepository;

    public List<CitaDTO> obtenerTodo(){
        return citaRepository.getAll();
    }

    public CitaDTO guardar(CitaDTO citaDTO){
        return citaRepository.save(citaDTO);
    }
}