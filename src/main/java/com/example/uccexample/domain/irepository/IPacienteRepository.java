package com.example.uccexample.domain.irepository;

import java.util.List;

import com.example.uccexample.domain.dto.PacienteDTO;

public interface IPacienteRepository {
    
    List<PacienteDTO> getAll();
    PacienteDTO save(PacienteDTO pacienteDTO);
    
}