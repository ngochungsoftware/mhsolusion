package com.example.demo.mapper;



import com.example.demo.dto.genre.request.GenreRequestDto;
import com.example.demo.entities.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper extends IMapperBasic<Genre, GenreRequestDto> {


}
