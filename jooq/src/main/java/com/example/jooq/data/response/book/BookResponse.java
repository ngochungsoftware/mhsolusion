package com.example.jooq.data.response.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookResponse {

        private String title;
        private Set<Integer> authors;
        private Set<Integer> genres;
        private Integer publicationYear;
        private String imageUrl;
        private String cloudinaryImageId;
        private Integer quantity;
        private Integer available;
}
