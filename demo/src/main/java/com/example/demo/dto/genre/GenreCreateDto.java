package com.example.demo.dto.genre;

import com.example.demo.dto.book.BookCreateDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreCreateDto implements Serializable {

    @NotBlank(message = "name is require")
    private String name;

    private Set<BookCreateDto> books = new LinkedHashSet<>();
}
