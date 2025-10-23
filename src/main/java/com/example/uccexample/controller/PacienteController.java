package com.example.uccexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uccexample.domain.dto.PacienteDTO;
import com.example.uccexample.domain.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<PacienteDTO> getAll() {
        return pacienteService.obtenerTodo();
    }

    @PostMapping
    public PacienteDTO save(@RequestBody PacienteDTO paciente) {
        return pacienteService.guardar(paciente);
    }
}