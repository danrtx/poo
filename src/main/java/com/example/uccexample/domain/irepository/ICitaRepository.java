package com.example.uccexample.domain.irepository;

import java.util.List;

import com.example.uccexample.domain.dto.CitaDTO;

public interface ICitaRepository {
    
    List<CitaDTO> getAll();
    CitaDTO save(CitaDTO citaDTO);
    
}