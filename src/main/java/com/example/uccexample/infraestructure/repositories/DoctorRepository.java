package com.example.uccexample.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.uccexample.domain.dto.DoctorDTO;
import com.example.uccexample.domain.irepository.IDoctorRepository;
import com.example.uccexample.infraestructure.crud.DoctorCrudRepository;
import com.example.uccexample.infraestructure.mapper.DoctorMapper;
import com.example.uccexample.infraestructure.model.Doctor;

@Repository
public class DoctorRepository implements IDoctorRepository {

    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    @Autowired
    private DoctorMapper mapper;

    @Override
    public List<DoctorDTO> getAll() {
        List<Doctor> doctores = (List<Doctor>) doctorCrudRepository.findAll();
        return mapper.toDoctorDTOs(doctores);
    }

    @Override
    public DoctorDTO save(DoctorDTO doctorDTO) {
        Doctor doctor = mapper.toDoctor(doctorDTO);
        return mapper.toDoctorDTO(doctorCrudRepository.save(doctor));
    }
}