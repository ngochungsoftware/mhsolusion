package com.example.demo.service.impl;

import com.example.demo.dto.book.BookCreateDto;
import com.example.demo.dto.book.BookDto;
import com.example.demo.dto.book.BookUpdateDto;
import com.example.demo.entities.Book;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.models.response.CloudinaryResponse;
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

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CloudinaryService cloudinaryService;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public BookDto save(BookCreateDto bookCreateDto) {
        Book book = bookMapper.toEntity(bookCreateDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    @Transactional
    public BookDto update(Integer id, BookUpdateDto bookUpdateDto) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Book updatedBook = bookMapper.toEntity(bookUpdateDto);
        updatedBook.setId(existingBook.getId());
        return bookMapper.toDto(bookRepository.save(updatedBook));
    }

//    @Override
//    public BookDto getOne(Integer id) {
//        Book book  = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
//        return bookMapper.toDto(book);
//    }

    @Override
    public BookDto getOne(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return bookMapper.toDto(optionalBook.get());
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
    public Page<BookDto> findAll(int limit, int offset) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        PageRequest pageable = PageRequest.of(offset / limit, limit);
        Page<Book> books = this.bookRepository.findAll(pageable);
        return  books.map(bookMapper::toDto);
    }


}
