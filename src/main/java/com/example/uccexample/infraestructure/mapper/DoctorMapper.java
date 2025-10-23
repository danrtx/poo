package com.example.uccexample.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.example.uccexample.domain.dto.DoctorDTO;
import com.example.uccexample.infraestructure.model.Doctor;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    @Mappings ({
        @Mapping(source = "idDoctor", target = "idDoctor"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "apellido", target = "apellido"),
        @Mapping(source = "especialidad", target = "especialidad"),
        @Mapping(source = "licenciaMedica", target = "licenciaMedica"),
        @Mapping(source = "telefono", target = "telefono"),
        @Mapping(source = "email", target = "email")
    })
    DoctorDTO toDoctorDTO(Doctor doctor);
    List<DoctorDTO> toDoctorDTOs(List<Doctor> doctores);

    @InheritInverseConfiguration
    @Mapping(target = "citas", ignore = true)
    Doctor toDoctor(DoctorDTO doctorDTO);
    List<Doctor> toDoctores(List<DoctorDTO> doctorDTOs);
}