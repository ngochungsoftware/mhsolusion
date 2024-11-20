package com.example.demo.controller;


import com.example.demo.dto.book.BookCreateDto;
import com.example.demo.dto.book.BookDto;
import com.example.demo.dto.book.BookUpdateDto;
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
    public ResponseEntity<Page<BookDto>> getAllBooks(
            @RequestParam(name = "limit", defaultValue = "5") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset) {
        Page<BookDto> books = bookService.findAll(limit, offset);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/save")
    public ResponseEntity<BookDto> saveBook(@RequestBody @Valid BookCreateDto bookCreateDto) {
        BookDto bookDto = bookService.save(bookCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Integer id,
                                              @RequestBody @Valid BookUpdateDto bookUpdateDto) {
        BookDto bookDto = bookService.update(id, bookUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(bookDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<BookDto>> deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("Book deleted successfully", null, 204));
    }

    @GetMapping("/{id}")
    public BookDto getOneBook(@PathVariable Integer id) {
        return bookService.getOne(id);
    }


}
