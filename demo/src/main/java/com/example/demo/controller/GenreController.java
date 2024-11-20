package com.example.demo.controller;

import com.example.demo.dto.genre.request.GenreRequestDto;
import com.example.demo.entities.Genre;
import com.example.demo.infrastructure.common.ApiResponse;
import com.example.demo.service.GenreServce;
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
@RequestMapping("/genres")
public class GenreController {
    GenreServce genreServce;

    @GetMapping
    public ResponseEntity<Page<Genre>> getAllAuthors(
            @RequestParam(name = "limit", defaultValue = "5") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset) {
        Page<Genre> books = genreServce.findAll(limit, offset);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/save")
    public ResponseEntity<Genre> save(@RequestBody @Valid GenreRequestDto genreCreateDto) {
        Genre Genre = genreServce.save(genreCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Genre);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Genre> update(@PathVariable Integer id,
                                                 @RequestBody @Valid GenreRequestDto genreUpdateDto) {
        Genre Genre = genreServce.update(id, genreUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(Genre);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Genre>> delete(@PathVariable Integer id) {
        genreServce.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("Author deleted successfully", null, 204));
    }

    @GetMapping("/{id}")
    public Genre getOne(@PathVariable Integer id) {
        return genreServce.getOne(id);
    }

}
