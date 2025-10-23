package com.example.uccexample.domain.irepository;

import java.util.List;

import com.example.uccexample.domain.dto.DoctorDTO;

public interface IDoctorRepository {
    
    List<DoctorDTO> getAll();
    DoctorDTO save(DoctorDTO doctorDTO);
    
}