package com.example.demo.service.impl;

import com.example.demo.dto.author.AuthorCreateDto;
import com.example.demo.dto.author.AuthorDto;
import com.example.demo.dto.author.AuthorUpdateDto;
import com.example.demo.entities.Author;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    @Transactional
    public AuthorDto save(AuthorCreateDto authorCreateDto) {
        Author author = authorMapper.toEntity(authorCreateDto);
        return authorMapper.toDto(authorRepository.save(author));
    }

    @Override
    @Transactional
    public AuthorDto update(Integer id, AuthorUpdateDto authorUpdateDto) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Author updatedAuthor = authorMapper.toEntity(authorUpdateDto);
        updatedAuthor.setId(existingAuthor.getId());
        return authorMapper.toDto(authorRepository.save(updatedAuthor));
    }

    @Override
    public AuthorDto getOne(Integer id) {
        Author author =  authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return authorMapper.toDto(author);
    }

    @Override
    public void delete(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Page<AuthorDto> findAll(int limit, int offset) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        PageRequest pageable = PageRequest.of(offset / limit, limit);
        Page<Author> authors = this.authorRepository.findAll(pageable);
        return  authors.map(authorMapper::toDto);
    }
}
