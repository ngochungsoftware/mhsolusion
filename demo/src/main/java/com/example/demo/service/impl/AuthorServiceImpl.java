package com.example.demo.service.impl;


import com.example.demo.dto.author.request.AuthorRequestDto;
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
    public Author save(AuthorRequestDto authorRequestDto) {
        Author author = authorMapper.toEntity(authorRequestDto);
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public Author update(Integer id, AuthorRequestDto authorRequestDto) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Author updatedAuthor = authorMapper.toEntity(authorRequestDto);
        updatedAuthor.setId(existingAuthor.getId());
        return authorRepository.save(updatedAuthor);
    }

    @Override
    public Author getOne(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public void delete(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Page<Author> findAll(int limit, int offset) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        PageRequest pageable = PageRequest.of(offset / limit, limit);
        return this.authorRepository.findAll(pageable);
    }
}
