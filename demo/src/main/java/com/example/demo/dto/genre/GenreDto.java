package com.example.demo.dto.genre;

import com.example.demo.dto.book.BookDto;

import java.io.Serializable;
import java.util.Set;

public record GenreDto(Integer id, String name, Set<BookDto> books) implements Serializable {

}
