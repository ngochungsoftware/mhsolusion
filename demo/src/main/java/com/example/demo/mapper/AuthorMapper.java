package com.example.demo.mapper;

import com.example.demo.dto.author.AuthorCreateDto;
import com.example.demo.dto.author.AuthorDto;
import com.example.demo.dto.author.AuthorUpdateDto;
import com.example.demo.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper{
    Author toEntity(Integer authorId);

    Author toEntity(AuthorDto authorDto);

    AuthorDto toDto(Author author);

    Author toEntity(AuthorCreateDto authorCreateDto);

    AuthorCreateDto toCreateDto(Author author);

    AuthorUpdateDto toUpdateDto(Author author);

    Author toEntity(AuthorUpdateDto authorUpdateDto);
}
