package com.example.uccexample.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.uccexample.domain.dto.HistoriaClinicaDTO;
import com.example.uccexample.domain.irepository.IHistoriaClinicaRepository;
import com.example.uccexample.infraestructure.crud.HistoriaClinicaCrudRepository;
import com.example.uccexample.infraestructure.mapper.HistoriaClinicaMapper;
import com.example.uccexample.infraestructure.model.HistoriaClinica;

@Repository
public class HistoriaClinicaRepository implements IHistoriaClinicaRepository {

    @Autowired
    private HistoriaClinicaCrudRepository historiaClinicaCrudRepository;

    @Autowired
    private HistoriaClinicaMapper mapper;

    @Override
    public List<HistoriaClinicaDTO> getAll() {
        List<HistoriaClinica> historiasClinicas = (List<HistoriaClinica>) historiaClinicaCrudRepository.findAll();
        return mapper.toHistoriaClinicaDTOs(historiasClinicas);
    }

    @Override
    public HistoriaClinicaDTO save(HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinica historiaClinica = mapper.toHistoriaClinica(historiaClinicaDTO);
        return mapper.toHistoriaClinicaDTO(historiaClinicaCrudRepository.save(historiaClinica));
    }
}