package com.example.demo.service;

import com.example.demo.dto.book.BookCreateDto;
import com.example.demo.dto.book.BookDto;
import com.example.demo.dto.book.BookUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface BookService {
    BookDto save(BookCreateDto bookCreateDto);

    BookDto update(Integer id, BookUpdateDto bookUpdateDto);

    BookDto getOne(Integer id);

    void delete(Integer id);

    void uploadImage(final Integer id, final MultipartFile file);

    // pagination : 2
    Page<BookDto> findAll(int limit, int offset);


}
