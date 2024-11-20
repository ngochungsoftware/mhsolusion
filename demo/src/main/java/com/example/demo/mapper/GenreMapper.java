package com.example.demo.mapper;


import com.example.demo.dto.genre.GenreCreateDto;
import com.example.demo.dto.genre.GenreDto;
import com.example.demo.dto.genre.GenreUpdateDto;
import com.example.demo.entities.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {
    Genre toEntity(Integer genreId);

    Genre toEntity(GenreDto genreDto);

    Genre toDto(Genre genre);

    Genre toEntity(GenreCreateDto genreCreateDto);

    GenreCreateDto toCreateDto(Genre genre);

    Genre toEntity(GenreUpdateDto genreUpdateDto);

    GenreUpdateDto toUpdateDto(Genre genre);
}
