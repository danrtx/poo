package com.example.uccexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uccexample.domain.dto.CitaDTO;
import com.example.uccexample.domain.service.CitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/")
    public List<CitaDTO> getAll() {
        return citaService.obtenerTodo();
    }

    @PostMapping("/")
    public CitaDTO save(@RequestBody CitaDTO cita) {
        return citaService.guardar(cita);
    }
}