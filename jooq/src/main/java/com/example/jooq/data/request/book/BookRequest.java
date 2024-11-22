package com.example.jooq.data.request.book;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    @NotNull(message = "Please enter a title!")
    private String title;
    private Set<Integer> authorIds;
    private Integer genreId;
    private Integer publicationYear;
    private String imageUrl;
    private String cloudinaryImageId;
    private Integer quantity;
    private Integer available;
}
