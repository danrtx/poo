package com.example.uccexample.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uccexample.domain.dto.TratamientoDTO;
import com.example.uccexample.infraestructure.repositories.TratamientoRepository;

@Service
public class TratamientoService {
    
    @Autowired
    private TratamientoRepository tratamientoRepository;

    public List<TratamientoDTO> obtenerTodo(){
        return tratamientoRepository.getAll();
    }

    public TratamientoDTO guardar(TratamientoDTO tratamientoDTO){
        return tratamientoRepository.save(tratamientoDTO);
    }
}