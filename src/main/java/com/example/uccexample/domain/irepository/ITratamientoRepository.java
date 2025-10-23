package com.example.uccexample.domain.irepository;

import java.util.List;

import com.example.uccexample.domain.dto.TratamientoDTO;

public interface ITratamientoRepository {
    
    List<TratamientoDTO> getAll();
    TratamientoDTO save(TratamientoDTO tratamientoDTO);
    
}