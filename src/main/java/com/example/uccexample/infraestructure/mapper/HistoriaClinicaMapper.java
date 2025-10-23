package com.example.uccexample.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.example.uccexample.domain.dto.HistoriaClinicaDTO;
import com.example.uccexample.infraestructure.model.HistoriaClinica;

@Mapper(componentModel = "spring")
public interface HistoriaClinicaMapper {
    @Mappings ({
        @Mapping(source = "idHistoria", target = "idHistoria"),
        @Mapping(source = "fechaCreacion", target = "fechaCreacion"),
        @Mapping(source = "grupoSanguineo", target = "grupoSanguineo"),
        @Mapping(source = "alergias", target = "alergias"),
        @Mapping(source = "antecedentes", target = "antecedentes"),
        @Mapping(source = "observaciones", target = "observaciones"),
        @Mapping(source = "paciente.idPaciente", target = "idPaciente")
    })
    HistoriaClinicaDTO toHistoriaClinicaDTO(HistoriaClinica historiaClinica);
    List<HistoriaClinicaDTO> toHistoriaClinicaDTOs(List<HistoriaClinica> historiasClinicas);

    @InheritInverseConfiguration
    @Mapping(target = "paciente", ignore = true)
    HistoriaClinica toHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO);
    List<HistoriaClinica> toHistoriasClinicas(List<HistoriaClinicaDTO> historiaClinicaDTOs);
}