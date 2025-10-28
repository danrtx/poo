package com.example.uccexample.infraestructure.repositories;

import com.example.uccexample.domain.irepository.IUsuarioRepository;
import com.example.uccexample.infraestructure.crud.UsuarioCrudRepository;
import com.example.uccexample.infraestructure.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepository implements IUsuarioRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioCrudRepository.findByUsername(username);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioCrudRepository.findByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return usuarioCrudRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return usuarioCrudRepository.existsByEmail(email);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioCrudRepository.save(usuario);
    }
}