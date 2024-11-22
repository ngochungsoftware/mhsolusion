package com.example.jooq.data.dtos.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private Set<Integer> authorIds;
    private Integer genreId;
    private Integer publicationYear;
    private String imageUrl;
    private String cloudinaryImageId;
    private Integer quantity;
    private Integer available;
}
