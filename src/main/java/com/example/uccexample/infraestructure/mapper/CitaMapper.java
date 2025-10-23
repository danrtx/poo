package com.example.uccexample.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.example.uccexample.domain.dto.CitaDTO;
import com.example.uccexample.infraestructure.model.Cita;

@Mapper(componentModel = "spring")
public interface CitaMapper {
    @Mappings ({
        @Mapping(source = "idCita", target = "idCita"),
        @Mapping(source = "fechaHora", target = "fechaHora"),
        @Mapping(source = "motivo", target = "motivo"),
        @Mapping(source = "estado", target = "estado"),
        @Mapping(source = "paciente.idPaciente", target = "idPaciente"),
        @Mapping(source = "doctor.idDoctor", target = "idDoctor")
    })
    CitaDTO toCitaDTO(Cita cita);
    List<CitaDTO> toCitaDTOs(List<Cita> citas);

    @InheritInverseConfiguration
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "tratamientos", ignore = true)
    Cita toCita(CitaDTO citaDTO);
    List<Cita> toCitas(List<CitaDTO> citaDTOs);
}