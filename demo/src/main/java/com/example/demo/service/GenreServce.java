package com.example.demo.service;


import com.example.demo.dto.genre.request.GenreRequestDto;
import com.example.demo.entities.Genre;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface GenreServce {
    Genre save(GenreRequestDto genreRequestDto);

    Genre update(Integer id, GenreRequestDto genreRequestDto);

    Genre getOne(Integer id);

    void delete(Integer id);

    Page<Genre> findAll(int limit, int offset);

}
