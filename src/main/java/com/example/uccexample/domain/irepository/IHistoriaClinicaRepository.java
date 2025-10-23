package com.example.uccexample.domain.irepository;

import java.util.List;

import com.example.uccexample.domain.dto.HistoriaClinicaDTO;

public interface IHistoriaClinicaRepository {
    
    List<HistoriaClinicaDTO> getAll();
    HistoriaClinicaDTO save(HistoriaClinicaDTO historiaClinicaDTO);
    
}