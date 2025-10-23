package com.example.uccexample.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uccexample.domain.dto.PacienteDTO;
import com.example.uccexample.infraestructure.repositories.PacienteRepository;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteDTO> obtenerTodo(){
        return pacienteRepository.getAll();
    }

    public PacienteDTO guardar(PacienteDTO pacienteDTO){
        return pacienteRepository.save(pacienteDTO);
    }
}