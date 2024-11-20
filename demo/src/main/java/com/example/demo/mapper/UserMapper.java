package com.example.demo.mapper;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.entities.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    User toEntity(UserCreateDto userCreateDto);

    UserCreateDto toCreateDto(User user);

    User toEntity(UserUpdateDto userUpdateDto);

    UserUpdateDto toUpdateDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserUpdateDto userUpdateDto, @MappingTarget User user);
/*
    // DTO chứa thông tin cần cập nhật
    UserUpdateDto updateDto = new UserUpdateDto();
    updateDto.setName("New Name");
    updateDto.setEmail(null); // Không cập nhật email

    // Đối tượng đích ban đầu
    User user = new User();
    user.setName("Old Name");
    user.setEmail("old.email@example.com");

    // Gọi phương thức partialUpdate
    mapper.partialUpdate(updateDto,user);

    // Kết quả: Chỉ name được cập nhật, email giữ nguyên
    // user.getName() => "New Name"
    // user.getEmail() => "old.email@example.com"

 */

}
