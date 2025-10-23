package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.CitaDTO;
import com.example.uccexample.infraestructure.model.Cita;
import com.example.uccexample.infraestructure.model.Doctor;
import com.example.uccexample.infraestructure.model.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-23T10:27:09-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class CitaMapperImpl implements CitaMapper {

    @Override
    public CitaDTO toCitaDTO(Cita cita) {
        if ( cita == null ) {
            return null;
        }

        CitaDTO citaDTO = new CitaDTO();

        citaDTO.setIdCita( cita.getIdCita() );
        citaDTO.setFechaHora( cita.getFechaHora() );
        citaDTO.setMotivo( cita.getMotivo() );
        citaDTO.setEstado( cita.getEstado() );
        citaDTO.setIdPaciente( citaPacienteIdPaciente( cita ) );
        citaDTO.setIdDoctor( citaDoctorIdDoctor( cita ) );

        return citaDTO;
    }

    @Override
    public List<CitaDTO> toCitaDTOs(List<Cita> citas) {
        if ( citas == null ) {
            return null;
        }

        List<CitaDTO> list = new ArrayList<CitaDTO>( citas.size() );
        for ( Cita cita : citas ) {
            list.add( toCitaDTO( cita ) );
        }

        return list;
    }

    @Override
    public Cita toCita(CitaDTO citaDTO) {
        if ( citaDTO == null ) {
            return null;
        }

        Cita cita = new Cita();

        cita.setIdCita( citaDTO.getIdCita() );
        cita.setFechaHora( citaDTO.getFechaHora() );
        cita.setMotivo( citaDTO.getMotivo() );
        cita.setEstado( citaDTO.getEstado() );

        return cita;
    }

    @Override
    public List<Cita> toCitas(List<CitaDTO> citaDTOs) {
        if ( citaDTOs == null ) {
            return null;
        }

        List<Cita> list = new ArrayList<Cita>( citaDTOs.size() );
        for ( CitaDTO citaDTO : citaDTOs ) {
            list.add( toCita( citaDTO ) );
        }

        return list;
    }

    private Long citaPacienteIdPaciente(Cita cita) {
        Paciente paciente = cita.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        return paciente.getIdPaciente();
    }

    private Long citaDoctorIdDoctor(Cita cita) {
        Doctor doctor = cita.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        return doctor.getIdDoctor();
    }
}
