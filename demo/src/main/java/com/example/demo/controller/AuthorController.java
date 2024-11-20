package com.example.demo.controller;


import com.example.demo.dto.author.AuthorCreateDto;
import com.example.demo.dto.author.AuthorDto;
import com.example.demo.dto.author.AuthorUpdateDto;
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
    public ResponseEntity<Page<AuthorDto>> getAllAuthors(
            @RequestParam(name = "limit", defaultValue = "5") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset) {
        Page<AuthorDto> books = authorService.findAll(limit, offset);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/save")
    public ResponseEntity<AuthorDto> saveAuthor(@RequestBody @Valid AuthorCreateDto authorCreateDto) {
        AuthorDto authorDto = authorService.save(authorCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Integer id,
                                              @RequestBody @Valid AuthorUpdateDto authorUpdateDto) {
        AuthorDto authorDto = authorService.update(id , authorUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(authorDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<AuthorDto>> deleteAuthor(@PathVariable Integer id) {
        authorService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("Author deleted successfully", null, 204));
    }

    @GetMapping("/{id}")
    public AuthorDto getOneAuthor(@PathVariable Integer id) {
        return authorService.getOne(id);
    }
}
