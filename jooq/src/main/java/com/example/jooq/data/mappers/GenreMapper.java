package com.example.jooq.data.mappers;

import com.example.jooq.data.entity.Genre;
import com.example.jooq.data.request.genre.GenreRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper extends IMapperBasic<Genre, GenreRequest> {
}
