package com.example.demo.controller;


import com.example.demo.dto.book.request.BookRequestDto;
import com.example.demo.entities.Book;
import com.example.demo.infrastructure.common.ApiResponse;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    BookService bookService;


    @PostMapping("/image/{id}")
    public ResponseEntity<String> uploadImage(@PathVariable final Integer id,
                                              @RequestPart final MultipartFile file) {
        this.bookService.uploadImage(id, file);
        return ResponseEntity.ok("Upload successfully");
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getAllBooks(
            @RequestParam(name = "limit", defaultValue = "5") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset) {
        Page<Book> books = bookService.findAll(limit, offset);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody @Valid BookRequestDto bookCreateDto) {
        Book Book = bookService.save(bookCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Book);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id,
                                              @RequestBody @Valid BookRequestDto bookUpdateDto) {
        Book Book = bookService.update(id, bookUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(Book);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Book>> deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("Book deleted successfully", null, 204));
    }

    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable Integer id) {
        return bookService.getOne(id);
    }


}
