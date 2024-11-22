package com.example.jooq.data.mappers;

import com.example.jooq.data.dtos.user.UserDTO;
import com.example.jooq.data.entity.User;
import com.example.jooq.data.request.user.UserRequest;
import com.example.jooq.data.response.user.UserResponse;
import com.example.jooq.generated.tables.records.UsersRecord;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    // Ánh xạ từ UsersRecord sang User Entity
    User toEntity(UsersRecord usersRecord);

    // Ánh xạ từ User Entity sang UsersRecord
    UsersRecord toRecord(User user);

    // Ánh xạ từ UsersRecord sang UserDTO
    UserResponse toDto(UsersRecord usersRecord);

    //    Ánh xạ từ UserDTO sang User Entity.
    User toEntity(UserDTO userDTO);

    //    Ánh xạ từ User Entity sang UserDTO.
    UserDTO toDto(User user);


    //    Ánh xạ từ UserRequest sang User Entity.
    User toEntity(UserRequest userRequest);

    //    → Ánh xạ từ User Entity sang UserRequest.
    UserRequest toRequestDto(User user);

    // if you one update some fields
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserRequest userRequest, @MappingTarget User user);
}


