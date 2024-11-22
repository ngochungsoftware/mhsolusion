package com.example.jooq.data.mappers;


import com.example.jooq.data.entity.Author;
import com.example.jooq.data.request.author.AuthorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper extends IMapperBasic<Author, AuthorRequest> {

}