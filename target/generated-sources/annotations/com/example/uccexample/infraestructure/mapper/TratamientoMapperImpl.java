package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.TratamientoDTO;
import com.example.uccexample.infraestructure.model.Cita;
import com.example.uccexample.infraestructure.model.Tratamiento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-28T14:51:32-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TratamientoMapperImpl implements TratamientoMapper {

    @Override
    public TratamientoDTO toTratamientoDTO(Tratamiento tratamiento) {
        if ( tratamiento == null ) {
            return null;
        }

        TratamientoDTO tratamientoDTO = new TratamientoDTO();

        tratamientoDTO.setIdTratamiento( tratamiento.getIdTratamiento() );
        tratamientoDTO.setNombre( tratamiento.getNombre() );
        tratamientoDTO.setDescripcion( tratamiento.getDescripcion() );
        tratamientoDTO.setFechaInicio( tratamiento.getFechaInicio() );
        tratamientoDTO.setFechaFin( tratamiento.getFechaFin() );
        tratamientoDTO.setEstado( tratamiento.getEstado() );
        tratamientoDTO.setIdCita( tratamientoCitaIdCita( tratamiento ) );

        return tratamientoDTO;
    }

    @Override
    public List<TratamientoDTO> toTratamientoDTOs(List<Tratamiento> tratamientos) {
        if ( tratamientos == null ) {
            return null;
        }

        List<TratamientoDTO> list = new ArrayList<TratamientoDTO>( tratamientos.size() );
        for ( Tratamiento tratamiento : tratamientos ) {
            list.add( toTratamientoDTO( tratamiento ) );
        }

        return list;
    }

    @Override
    public Tratamiento toTratamiento(TratamientoDTO tratamientoDTO) {
        if ( tratamientoDTO == null ) {
            return null;
        }

        Tratamiento tratamiento = new Tratamiento();

        tratamiento.setIdTratamiento( tratamientoDTO.getIdTratamiento() );
        tratamiento.setNombre( tratamientoDTO.getNombre() );
        tratamiento.setDescripcion( tratamientoDTO.getDescripcion() );
        tratamiento.setFechaInicio( tratamientoDTO.getFechaInicio() );
        tratamiento.setFechaFin( tratamientoDTO.getFechaFin() );
        tratamiento.setEstado( tratamientoDTO.getEstado() );

        return tratamiento;
    }

    @Override
    public List<Tratamiento> toTratamientos(List<TratamientoDTO> tratamientoDTOs) {
        if ( tratamientoDTOs == null ) {
            return null;
        }

        List<Tratamiento> list = new ArrayList<Tratamiento>( tratamientoDTOs.size() );
        for ( TratamientoDTO tratamientoDTO : tratamientoDTOs ) {
            list.add( toTratamiento( tratamientoDTO ) );
        }

        return list;
    }

    private Long tratamientoCitaIdCita(Tratamiento tratamiento) {
        if ( tratamiento == null ) {
            return null;
        }
        Cita cita = tratamiento.getCita();
        if ( cita == null ) {
            return null;
        }
        Long idCita = cita.getIdCita();
        if ( idCita == null ) {
            return null;
        }
        return idCita;
    }
}
