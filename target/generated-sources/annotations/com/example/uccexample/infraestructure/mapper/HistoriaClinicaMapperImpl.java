package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.HistoriaClinicaDTO;
import com.example.uccexample.infraestructure.model.HistoriaClinica;
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
public class HistoriaClinicaMapperImpl implements HistoriaClinicaMapper {

    @Override
    public HistoriaClinicaDTO toHistoriaClinicaDTO(HistoriaClinica historiaClinica) {
        if ( historiaClinica == null ) {
            return null;
        }

        HistoriaClinicaDTO historiaClinicaDTO = new HistoriaClinicaDTO();

        historiaClinicaDTO.setIdHistoria( historiaClinica.getIdHistoria() );
        historiaClinicaDTO.setFechaCreacion( historiaClinica.getFechaCreacion() );
        historiaClinicaDTO.setGrupoSanguineo( historiaClinica.getGrupoSanguineo() );
        historiaClinicaDTO.setAlergias( historiaClinica.getAlergias() );
        historiaClinicaDTO.setAntecedentes( historiaClinica.getAntecedentes() );
        historiaClinicaDTO.setObservaciones( historiaClinica.getObservaciones() );
        historiaClinicaDTO.setIdPaciente( historiaClinicaPacienteIdPaciente( historiaClinica ) );

        return historiaClinicaDTO;
    }

    @Override
    public List<HistoriaClinicaDTO> toHistoriaClinicaDTOs(List<HistoriaClinica> historiasClinicas) {
        if ( historiasClinicas == null ) {
            return null;
        }

        List<HistoriaClinicaDTO> list = new ArrayList<HistoriaClinicaDTO>( historiasClinicas.size() );
        for ( HistoriaClinica historiaClinica : historiasClinicas ) {
            list.add( toHistoriaClinicaDTO( historiaClinica ) );
        }

        return list;
    }

    @Override
    public HistoriaClinica toHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO) {
        if ( historiaClinicaDTO == null ) {
            return null;
        }

        HistoriaClinica historiaClinica = new HistoriaClinica();

        historiaClinica.setIdHistoria( historiaClinicaDTO.getIdHistoria() );
        historiaClinica.setFechaCreacion( historiaClinicaDTO.getFechaCreacion() );
        historiaClinica.setGrupoSanguineo( historiaClinicaDTO.getGrupoSanguineo() );
        historiaClinica.setAlergias( historiaClinicaDTO.getAlergias() );
        historiaClinica.setAntecedentes( historiaClinicaDTO.getAntecedentes() );
        historiaClinica.setObservaciones( historiaClinicaDTO.getObservaciones() );

        return historiaClinica;
    }

    @Override
    public List<HistoriaClinica> toHistoriasClinicas(List<HistoriaClinicaDTO> historiaClinicaDTOs) {
        if ( historiaClinicaDTOs == null ) {
            return null;
        }

        List<HistoriaClinica> list = new ArrayList<HistoriaClinica>( historiaClinicaDTOs.size() );
        for ( HistoriaClinicaDTO historiaClinicaDTO : historiaClinicaDTOs ) {
            list.add( toHistoriaClinica( historiaClinicaDTO ) );
        }

        return list;
    }

    private Long historiaClinicaPacienteIdPaciente(HistoriaClinica historiaClinica) {
        if ( historiaClinica == null ) {
            return null;
        }
        Paciente paciente = historiaClinica.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        Long idPaciente = paciente.getIdPaciente();
        if ( idPaciente == null ) {
            return null;
        }
        return idPaciente;
    }
}
