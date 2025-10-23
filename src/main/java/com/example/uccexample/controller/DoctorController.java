package com.example.uccexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uccexample.domain.dto.DoctorDTO;
import com.example.uccexample.domain.service.DoctorService;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/")
    public List<DoctorDTO> getAll() {
        return doctorService.obtenerTodo();
    }

    @PostMapping("/")
    public DoctorDTO save(@RequestBody DoctorDTO doctor) {
        return doctorService.guardar(doctor);
    }
}