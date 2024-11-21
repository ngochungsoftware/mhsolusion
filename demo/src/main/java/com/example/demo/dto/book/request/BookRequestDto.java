package com.example.demo.dto.book.request;


import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookRequestDto {
    private String title;
    private Set<Integer> authorIds;
    private Integer genreId;
    private Integer publicationYear;
    private String imageUrl;
    private String cloudinaryImageId;
    private Integer quantity;
    private Integer available;
}
