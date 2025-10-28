package com.example.uccexample.controller;

import com.example.uccexample.domain.dto.JwtResponse;
import com.example.uccexample.domain.dto.LoginRequest;
import com.example.uccexample.domain.dto.SignupRequest;
import com.example.uccexample.domain.irepository.IRolRepository;
import com.example.uccexample.domain.irepository.IUsuarioRepository;
import com.example.uccexample.infraestructure.model.Rol;
import com.example.uccexample.infraestructure.model.Rol.RolNombre;
import com.example.uccexample.infraestructure.model.Usuario;
import com.example.uccexample.security.jwt.JwtUtils;
import com.example.uccexample.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IRolRepository rolRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, 
                                                 userDetails.getId(), 
                                                 userDetails.getUsername(), 
                                                 userDetails.getEmail(), 
                                                 roles));
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (usuarioRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: El nombre de usuario ya está en uso");
        }

        if (usuarioRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: El email ya está en uso");
        }

        // Crear nueva cuenta de usuario
        Usuario usuario = new Usuario(signUpRequest.getUsername(),
                                     encoder.encode(signUpRequest.getPassword()),
                                     signUpRequest.getNombre(),
                                     signUpRequest.getApellido(),
                                     signUpRequest.getEmail());

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Rol> roles = new HashSet<>();

        if (strRoles == null) {
            Rol userRole = rolRepository.findByNombre(RolNombre.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                case "admin":
                    Rol adminRole = rolRepository.findByNombre(RolNombre.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                    roles.add(adminRole);
                    break;
                case "doctor":
                    Rol modRole = rolRepository.findByNombre(RolNombre.ROLE_DOCTOR)
                            .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                    roles.add(modRole);
                    break;
                default:
                    Rol userRole = rolRepository.findByNombre(RolNombre.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                    roles.add(userRole);
                }
            });
        }

        usuario.setRoles(roles);
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}