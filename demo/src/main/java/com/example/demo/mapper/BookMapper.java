package com.example.demo.mapper;


import com.example.demo.dto.book.BookCreateDto;
import com.example.demo.dto.book.BookDto;
import com.example.demo.dto.book.BookUpdateDto;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Genre;
import com.example.demo.repositories.AuthorRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
//        uses = {AuthorMapper.class, GenreMapper.class})
//public interface BookMapper {
//    Book toEntity(BookDto bookDto);
//
//    BookDto toDto(Book book);
//
//    @Mapping(source = "authors", target = "author")  // Ánh xạ từ authors (ID) sang Author đối tượng
//    @Mapping(source = "genres", target = "genre")
//    Book toEntity(BookCreateDto bookCreateDto);
//
//    BookCreateDto toBookCreateDto(Book book);
//
//    Book toEntity(BookUpdateDto bookUpdateDto);
//
//    BookUpdateDto toBookUpdateDto(Book book);
//
//    void partialUpdate(BookUpdateDto bookUpdateDto, @MappingTarget Book book);
//
//    // Use MapStruct's `@MappingTarget` to update an existing Book entity
//    // @Mapping(target = "deleted", ignore = true)
//    // Don't overwrite the deleted flag
//    // Don't overwrite the ID
//    @Mapping(target = "id", ignore = true)
//    void updateEntity(BookUpdateDto dto, @MappingTarget Book entity);
//
//    @AfterMapping
//    default void handleNulls(BookUpdateDto dto, @MappingTarget Book entity) {
//        if (dto.getTitle() == null) {
//            entity.setTitle(null);  // For example, handle null cases for specific fields
//        }
//        // Add similar logic for other fields if necessary
//    }
//}

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {AuthorMapper.class, GenreMapper.class})
public abstract class BookMapper {

    @Autowired
    private AuthorRepository authorRepository;

    public abstract Book toEntity(BookDto bookDto);

    public abstract BookDto toDto(Book book);

    @Mapping(source = "authors", target = "author", qualifiedByName = "mapAuthorFromId")
    public abstract Book toEntity(BookCreateDto bookCreateDto);

    public abstract Book toEntity(BookUpdateDto bookUpdateDto);

    public abstract BookCreateDto toBookCreateDto(Book book);

    @Mapping(target = "id", ignore = true)
    public abstract void updateEntity(BookUpdateDto dto, @MappingTarget Book entity);

    public abstract BookUpdateDto toBookUpdateDto(Book book);

    // Lấy author đầu tiên từ Set của IDs
    Author mapAuthorFromIds(Set<Integer> authorIds) {
        if (authorIds == null || authorIds.isEmpty()) {
            return null;
        }
        Integer authorId = authorIds.iterator().next(); // Lấy ID đầu tiên
        Author author = new Author();
        author.setId(authorId);
        return author;
    }

//    // Map Set of IDs to Set of Authors
//    default Set<Author> mapAuthorsFromIds(Set<Integer> authorIds) {
//        if (authorIds == null) {
//            return new HashSet<>();
//        }
//        return authorIds.stream()
//                .map(id -> {
//                    Author author = new Author();
//                    author.setId(id);
//                    return author;
//                })
//                .collect(Collectors.toSet());
//    }

    // Lấy genre đầu tiên từ Set của IDs (vì chỉ cần 1 genre)

    Genre mapGenreFromIds(Set<Integer> genreIds) {
        if (genreIds == null || genreIds.isEmpty()) {
            return null;
        }
        Integer genreId = genreIds.iterator().next();
        Genre genre = new Genre();
        genre.setId(genreId);
        return genre;
    }

    @Named("mapAuthorFromId")
    Author mapAuthorFromId(Integer value) {
        return authorRepository.findById(value).orElseThrow();
    }

}