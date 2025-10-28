package com.example.uccexample.infraestructure.crud;

import com.example.uccexample.infraestructure.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}