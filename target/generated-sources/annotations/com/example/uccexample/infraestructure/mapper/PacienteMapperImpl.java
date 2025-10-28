package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.PacienteDTO;
import com.example.uccexample.infraestructure.model.Paciente;
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
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public PacienteDTO toPacienteDTO(Paciente paciente) {
        if ( paciente == null ) {
            return null;
        }

        PacienteDTO pacienteDTO = new PacienteDTO();

        pacienteDTO.setIdPaciente( paciente.getIdPaciente() );
        pacienteDTO.setNombre( paciente.getNombre() );
        pacienteDTO.setApellido( paciente.getApellido() );
        pacienteDTO.setDocumento( paciente.getDocumento() );
        pacienteDTO.setTelefono( paciente.getTelefono() );
        pacienteDTO.setDireccion( paciente.getDireccion() );

        return pacienteDTO;
    }

    @Override
    public List<PacienteDTO> toPacienteDTOs(List<Paciente> pacientes) {
        if ( pacientes == null ) {
            return null;
        }

        List<PacienteDTO> list = new ArrayList<PacienteDTO>( pacientes.size() );
        for ( Paciente paciente : pacientes ) {
            list.add( toPacienteDTO( paciente ) );
        }

        return list;
    }

    @Override
    public Paciente toPaciente(PacienteDTO pacienteDTO) {
        if ( pacienteDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setIdPaciente( pacienteDTO.getIdPaciente() );
        paciente.setNombre( pacienteDTO.getNombre() );
        paciente.setApellido( pacienteDTO.getApellido() );
        paciente.setDocumento( pacienteDTO.getDocumento() );
        paciente.setTelefono( pacienteDTO.getTelefono() );
        paciente.setDireccion( pacienteDTO.getDireccion() );

        return paciente;
    }

    @Override
    public List<Paciente> toPacientes(List<PacienteDTO> pacienteDTOs) {
        if ( pacienteDTOs == null ) {
            return null;
        }

        List<Paciente> list = new ArrayList<Paciente>( pacienteDTOs.size() );
        for ( PacienteDTO pacienteDTO : pacienteDTOs ) {
            list.add( toPaciente( pacienteDTO ) );
        }

        return list;
    }
}
