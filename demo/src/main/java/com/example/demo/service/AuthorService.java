package com.example.demo.service;



import com.example.demo.dto.author.request.AuthorRequestDto;
import com.example.demo.entities.Author;
import org.springframework.data.domain.Page;

public interface AuthorService {

    Author save(AuthorRequestDto authorRequestDto);

    Author update(Integer id, AuthorRequestDto authorRequestDto);

    Author getOne(Integer id);

    void delete(Integer id);

    // pagination : 2
    Page<Author> findAll(int limit, int offset);
}
