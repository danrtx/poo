package com.example.uccexample.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.example.uccexample.domain.dto.TratamientoDTO;
import com.example.uccexample.infraestructure.model.Tratamiento;

@Mapper(componentModel = "spring")
public interface TratamientoMapper {
    @Mappings ({
        @Mapping(source = "idTratamiento", target = "idTratamiento"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "descripcion", target = "descripcion"),
        @Mapping(source = "fechaInicio", target = "fechaInicio"),
        @Mapping(source = "fechaFin", target = "fechaFin"),
        @Mapping(source = "estado", target = "estado"),
        @Mapping(source = "cita.idCita", target = "idCita")
    })
    TratamientoDTO toTratamientoDTO(Tratamiento tratamiento);
    List<TratamientoDTO> toTratamientoDTOs(List<Tratamiento> tratamientos);

    @InheritInverseConfiguration
    @Mapping(target = "cita", ignore = true)
    Tratamiento toTratamiento(TratamientoDTO tratamientoDTO);
    List<Tratamiento> toTratamientos(List<TratamientoDTO> tratamientoDTOs);
}