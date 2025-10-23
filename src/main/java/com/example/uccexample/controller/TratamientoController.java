package com.example.uccexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uccexample.domain.dto.TratamientoDTO;
import com.example.uccexample.domain.service.TratamientoService;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("/")
    public List<TratamientoDTO> getAll() {
        return tratamientoService.obtenerTodo();
    }

    @PostMapping("/")
    public TratamientoDTO save(@RequestBody TratamientoDTO tratamiento) {
        return tratamientoService.guardar(tratamiento);
    }
}