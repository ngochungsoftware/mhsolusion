package com.example.demo.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateDto implements Serializable {
    @NotBlank(message = "Title is require")
    private String title;

    @NotNull(message = "Require at least 1 author")
    private Set<Integer> authorIds;

    @NotNull(message = "Require at least 1 author")
    private Set<Integer> genreIds;

    private Integer publicationYear;

    @NotBlank
    @Length(min = 8)
    private Integer quantity;

}
