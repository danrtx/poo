package com.example.uccexample.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.uccexample.domain.dto.CitaDTO;
import com.example.uccexample.domain.irepository.ICitaRepository;
import com.example.uccexample.infraestructure.crud.CitaCrudRepository;
import com.example.uccexample.infraestructure.mapper.CitaMapper;
import com.example.uccexample.infraestructure.model.Cita;

@Repository
public class CitaRepository implements ICitaRepository {

    @Autowired
    private CitaCrudRepository citaCrudRepository;

    @Autowired
    private CitaMapper mapper;

    @Override
    public List<CitaDTO> getAll() {
        List<Cita> citas = (List<Cita>) citaCrudRepository.findAll();
        return mapper.toCitaDTOs(citas);
    }

    @Override
    public CitaDTO save(CitaDTO citaDTO) {
        Cita cita = mapper.toCita(citaDTO);
        return mapper.toCitaDTO(citaCrudRepository.save(cita));
    }
}