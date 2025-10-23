package com.example.uccexample.domain.irepository;

import java.util.List;

import com.example.uccexample.domain.dto.AuthorDTO;

public interface IAuthorRepository {
    
    List<AuthorDTO> getAll();
    AuthorDTO save(AuthorDTO authorDTO);
    
}
