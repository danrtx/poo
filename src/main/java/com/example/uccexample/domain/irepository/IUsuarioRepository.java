package com.example.uccexample.domain.irepository;

import com.example.uccexample.infraestructure.model.Usuario;

import java.util.Optional;

public interface IUsuarioRepository {
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Usuario save(Usuario usuario);
}