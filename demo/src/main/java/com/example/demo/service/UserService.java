package com.example.demo.service;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.models.PaginateParam;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto save(UserCreateDto userDto);

    UserDto update(Integer id, UserUpdateDto userUpdateDto);

    UserDto getOne(Integer id);

    void delete(Integer id);

    Iterable<UserDto> getAllUsers(PaginateParam paginateParam);
}

