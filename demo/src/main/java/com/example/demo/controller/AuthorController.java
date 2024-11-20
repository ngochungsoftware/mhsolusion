package com.example.demo.controller;



import com.example.demo.dto.author.request.AuthorRequestDto;
import com.example.demo.entities.Author;
import com.example.demo.infrastructure.common.ApiResponse;
import com.example.demo.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("/authors")
public class AuthorController {
    
    AuthorService authorService;

    @GetMapping
    public ResponseEntity<Page<Author>> getAllAuthors(
            @RequestParam(name = "limit", defaultValue = "5") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset) {
        Page<Author> books = authorService.findAll(limit, offset);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/save")
    public ResponseEntity<Author> saveAuthor(@RequestBody @Valid AuthorRequestDto authorCreateDto) {
        Author author = authorService.save(authorCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Integer id,
                                              @RequestBody @Valid AuthorRequestDto authorUpdateDto) {
        Author author = authorService.update(id , authorUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(author);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Author>> deleteAuthor(@PathVariable Integer id) {
        authorService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("Author deleted successfully", null, 204));
    }

    @GetMapping("/{id}")
    public Author getOneAuthor(@PathVariable Integer id) {
        return authorService.getOne(id);
    }
}
