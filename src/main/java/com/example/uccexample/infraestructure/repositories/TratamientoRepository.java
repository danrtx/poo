package com.example.uccexample.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.uccexample.domain.dto.TratamientoDTO;
import com.example.uccexample.domain.irepository.ITratamientoRepository;
import com.example.uccexample.infraestructure.crud.TratamientoCrudRepository;
import com.example.uccexample.infraestructure.mapper.TratamientoMapper;
import com.example.uccexample.infraestructure.model.Tratamiento;

@Repository
public class TratamientoRepository implements ITratamientoRepository {

    @Autowired
    private TratamientoCrudRepository tratamientoCrudRepository;

    @Autowired
    private TratamientoMapper mapper;

    @Override
    public List<TratamientoDTO> getAll() {
        List<Tratamiento> tratamientos = (List<Tratamiento>) tratamientoCrudRepository.findAll();
        return mapper.toTratamientoDTOs(tratamientos);
    }

    @Override
    public TratamientoDTO save(TratamientoDTO tratamientoDTO) {
        Tratamiento tratamiento = mapper.toTratamiento(tratamientoDTO);
        return mapper.toTratamientoDTO(tratamientoCrudRepository.save(tratamiento));
    }
}