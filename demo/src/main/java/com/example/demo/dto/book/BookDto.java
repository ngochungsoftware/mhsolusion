package com.example.demo.dto.book;

import com.example.demo.entities.Author;
import com.example.demo.entities.Genre;

import java.io.Serializable;


/**
 * @author ngochungsoftware
 * Vui lòng không chỉnh sửa, có sửa hãy copy, hoặc để lại cmt =))
 */

public record BookDto(
        Integer id,
        String title,
        Author author,
        Genre genre,
        Integer publicationYear,
        String imageUrl,
        String cloudinaryImageId,
        Integer quantity,
        Integer available
) implements Serializable {
}
