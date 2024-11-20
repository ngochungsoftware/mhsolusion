package com.example.demo.service.impl;

import com.example.demo.dto.book.request.BookRequestDto;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.models.response.CloudinaryResponse;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.CloudinaryService;
import com.example.demo.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CloudinaryService cloudinaryService;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public Book save(BookRequestDto bookRequestDto) {
        Book book = bookMapper.toEntity(bookRequestDto);
        Set<Author> authors = new LinkedHashSet<>();
        for (Integer authorId : bookRequestDto.getAuthorIds()) {
            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new NotFoundException("Author not found with id: " + authorId));
            authors.add(author);
        }
        book.setAuthors(authors);
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book update(Integer id, BookRequestDto bookRequestDto) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Book updatedBook = bookMapper.toEntity(bookRequestDto);
        updatedBook.setId(existingBook.getId());
        return bookRepository.save(updatedBook);
    }

    @Override
    public Book getOne(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void uploadImage(final Integer id, final MultipartFile file) {
        final Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found!"));
        FileUploadUtil.assertAllowed(file, FileUploadUtil.IMAGE_PATTERN);
        final String fileName = FileUploadUtil.getFileName(file.getOriginalFilename());
        final CloudinaryResponse response = this.cloudinaryService.uploadFile(file, fileName);
        book.setImageUrl(response.getUrl());
        book.setCloudinaryImageId(response.getPublicId());
        this.bookRepository.save(book);
    }

    @Override
    public Page<Book> findAll(int limit, int offset) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        PageRequest pageable = PageRequest.of(offset / limit, limit);
        return this.bookRepository.findAll(pageable);
    }


}
