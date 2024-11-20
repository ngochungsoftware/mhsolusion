package com.example.demo.mapper;


import com.example.demo.dto.author.request.AuthorRequestDto;
import com.example.demo.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper extends IMapperBasic<Author, AuthorRequestDto> {

}
