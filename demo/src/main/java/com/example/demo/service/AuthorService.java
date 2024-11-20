package com.example.demo.service;


import com.example.demo.dto.author.AuthorCreateDto;
import com.example.demo.dto.author.AuthorDto;
import com.example.demo.dto.author.AuthorUpdateDto;
import org.springframework.data.domain.Page;

public interface AuthorService {

    AuthorDto save(AuthorCreateDto authorCreateDto);

    AuthorDto update(Integer id, AuthorUpdateDto authorUpdateDto);

    AuthorDto getOne(Integer id);

    void delete(Integer id);

    // pagination : 2
    Page<AuthorDto> findAll(int limit, int offset);
}
