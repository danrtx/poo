package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.DoctorDTO;
import com.example.uccexample.infraestructure.model.Doctor;
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
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorDTO toDoctorDTO(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setIdDoctor( doctor.getIdDoctor() );
        doctorDTO.setNombre( doctor.getNombre() );
        doctorDTO.setApellido( doctor.getApellido() );
        doctorDTO.setEspecialidad( doctor.getEspecialidad() );
        doctorDTO.setLicenciaMedica( doctor.getLicenciaMedica() );
        doctorDTO.setTelefono( doctor.getTelefono() );
        doctorDTO.setEmail( doctor.getEmail() );

        return doctorDTO;
    }

    @Override
    public List<DoctorDTO> toDoctorDTOs(List<Doctor> doctores) {
        if ( doctores == null ) {
            return null;
        }

        List<DoctorDTO> list = new ArrayList<DoctorDTO>( doctores.size() );
        for ( Doctor doctor : doctores ) {
            list.add( toDoctorDTO( doctor ) );
        }

        return list;
    }

    @Override
    public Doctor toDoctor(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setIdDoctor( doctorDTO.getIdDoctor() );
        doctor.setNombre( doctorDTO.getNombre() );
        doctor.setApellido( doctorDTO.getApellido() );
        doctor.setEspecialidad( doctorDTO.getEspecialidad() );
        doctor.setLicenciaMedica( doctorDTO.getLicenciaMedica() );
        doctor.setTelefono( doctorDTO.getTelefono() );
        doctor.setEmail( doctorDTO.getEmail() );

        return doctor;
    }

    @Override
    public List<Doctor> toDoctores(List<DoctorDTO> doctorDTOs) {
        if ( doctorDTOs == null ) {
            return null;
        }

        List<Doctor> list = new ArrayList<Doctor>( doctorDTOs.size() );
        for ( DoctorDTO doctorDTO : doctorDTOs ) {
            list.add( toDoctor( doctorDTO ) );
        }

        return list;
    }
}
