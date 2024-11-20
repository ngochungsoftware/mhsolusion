package com.example.demo.dto.book.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookResponseDto {
    private String title;
    private Set<Integer> authors;
    private Set<Integer> genres;
    private Integer year;
    private String imageUrl;
    private String cloudinaryImageId;
    private Integer quantity;
    private Integer available;
}
