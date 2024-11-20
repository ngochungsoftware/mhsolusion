package com.example.demo.mapper;


import com.example.demo.dto.book.request.BookRequestDto;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Genre;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.GenreRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {AuthorMapper.class, GenreMapper.class}
)
public abstract class BookMapper {

    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private GenreRepository genreRepository;


    @Mappings({@Mapping(source = "authorIds", target = "authors", qualifiedByName = "mapAuthorIdsToAuthors"),
            @Mapping(source = "genreId", target = "genre", qualifiedByName = "mapGenreIdToGenre")})
    public abstract Book toEntity(BookRequestDto bookRequestDto);

    @Named("mapAuthorIdsToAuthors")
    public Set<Author> mapAuthorIdsToAuthors(Set<Integer> authorIds) {
        Set<Author> authors = new HashSet<>();
        for (Integer authorId : authorIds) {
            Author author = authorRepository.findById(authorId).orElseThrow(() -> new NotFoundException("Author not found with id: " + authorId));
            authors.add(author);
        }
        return authors;
    }

    @Named("mapGenreIdToGenre")
    public Genre mapGenreIdToGenre(Integer genreId) {
        return genreRepository.findById(genreId).orElseThrow(() -> new NotFoundException("Genre not found with id: " + genreId));
    }


}
