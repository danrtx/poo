package com.example.uccexample.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.uccexample.domain.dto.PacienteDTO;
import com.example.uccexample.domain.irepository.IPacienteRepository;
import com.example.uccexample.infraestructure.crud.PacienteCrudRepository;
import com.example.uccexample.infraestructure.mapper.PacienteMapper;
import com.example.uccexample.infraestructure.model.Paciente;

@Repository
public class PacienteRepository implements IPacienteRepository {

    @Autowired
    private PacienteCrudRepository pacienteCrudRepository;

    @Autowired
    private PacienteMapper mapper;

    @Override
    public List<PacienteDTO> getAll() {
        List<Paciente> pacientes = (List<Paciente>) pacienteCrudRepository.findAll();
        return mapper.toPacienteDTOs(pacientes);
    }

    @Override
    public PacienteDTO save(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.toPaciente(pacienteDTO);
        return mapper.toPacienteDTO(pacienteCrudRepository.save(paciente));
    }
}