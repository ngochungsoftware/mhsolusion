package com.example.demo.service;

import com.example.demo.dto.book.request.BookRequestDto;
import com.example.demo.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface BookService {
    Book save(BookRequestDto bookRequestDto);

    Book update(Integer id, BookRequestDto bookRequestDto);

    Book getOne(Integer id);

    void delete(Integer id);

    void uploadImage(final Integer id, final MultipartFile file);

    // pagination : 2
    Page<Book> findAll(int limit, int offset);


}
