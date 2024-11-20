package com.example.demo.mapper;

import com.example.demo.dto.user.request.UserRequestDto;
import com.example.demo.entities.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends IMapperBasic<User, UserRequestDto> {


}
