package com.example.uccexample.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uccexample.domain.dto.HistoriaClinicaDTO;
import com.example.uccexample.infraestructure.repositories.HistoriaClinicaRepository;

@Service
public class HistoriaClinicaService {
    
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<HistoriaClinicaDTO> obtenerTodo(){
        return historiaClinicaRepository.getAll();
    }

    public HistoriaClinicaDTO guardar(HistoriaClinicaDTO historiaClinicaDTO){
        return historiaClinicaRepository.save(historiaClinicaDTO);
    }
}