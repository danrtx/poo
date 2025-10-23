package com.example.uccexample.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.example.uccexample.domain.dto.PacienteDTO;
import com.example.uccexample.infraestructure.model.Paciente;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    @Mappings ({
        @Mapping(source = "idPaciente", target = "idPaciente"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "apellido", target = "apellido"),
        @Mapping(source = "documento", target = "documento"),
        @Mapping(source = "telefono", target = "telefono"),
        @Mapping(source = "direccion", target = "direccion")
    })
    PacienteDTO toPacienteDTO(Paciente paciente);
    List<PacienteDTO> toPacienteDTOs(List<Paciente> pacientes);

    @InheritInverseConfiguration
    @Mapping(target = "citas", ignore = true)
    @Mapping(target = "historiaClinica", ignore = true)
    Paciente toPaciente(PacienteDTO pacienteDTO);
    List<Paciente> toPacientes(List<PacienteDTO> pacienteDTOs);
}