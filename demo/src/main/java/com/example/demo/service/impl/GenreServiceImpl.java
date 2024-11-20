package com.example.demo.service.impl;


import com.example.demo.dto.genre.request.GenreRequestDto;
import com.example.demo.entities.Genre;
import com.example.demo.mapper.GenreMapper;
import com.example.demo.repositories.GenreRepository;
import com.example.demo.service.GenreServce;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreServce {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    @Transactional
    public Genre save(GenreRequestDto genreRequestDto) {
        Genre genre = genreMapper.toEntity(genreRequestDto);
        return genreRepository.save(genre);
    }

    @Override
    @Transactional
    public Genre update(Integer id, GenreRequestDto genreRequestDto) {
        Genre existingGenre = genreRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Genre not found"));
        Genre updatedGenre = genreMapper.toEntity(genreRequestDto);
        updatedGenre.setId(existingGenre.getId());
        return genreRepository.save(updatedGenre);
    }

    @Override
    public Genre getOne(Integer id) {
        return genreRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Genre not found"));
    }

    @Override
    public void delete(Integer id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Page<Genre> findAll(int limit, int offset) {

        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        PageRequest pageable = PageRequest.of(offset / limit, limit);
        Page<Genre> genres = this.genreRepository.findAll(pageable);
        return genres;
    }
}
