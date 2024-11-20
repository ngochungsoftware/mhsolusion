package com.example.demo.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateDto implements Serializable {

    @NotBlank(message = "Title is require")
    private String title;

    @NotNull(message = "Require at least 1 author")
    private Set<Integer> authors = new LinkedHashSet<>();

    @NotNull(message = "Require at least 1 author")
    private Set<Integer> genres = new LinkedHashSet<>();

    private Integer publicationYear;

    @NotNull
    @Min(1)
    private Integer quantity;

    private Integer available;
}
