package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.DoctorDTO;
import com.example.uccexample.infraestructure.model.Doctor;
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
