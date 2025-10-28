package com.example.uccexample.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @GetMapping("/all")
    public String allAccess() {
        return "Contenido público";
    }
    
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('DOCTOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "Contenido de Usuario";
    }

    @GetMapping("/doctor")
    @PreAuthorize("hasRole('DOCTOR')")
    public String doctorAccess() {
        return "Contenido de Doctor";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Contenido de Admin";
    }
}