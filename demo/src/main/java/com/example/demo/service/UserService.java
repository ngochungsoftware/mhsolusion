package com.example.demo.service;

import com.example.demo.dto.user.request.UserRequestDto;
import com.example.demo.entities.User;
import com.example.demo.models.PaginateParam;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User save(UserRequestDto userRequestDto);

    User update(Integer id, UserRequestDto userRequestDto);

    User getOne(Integer id);

    void delete(Integer id);

    Iterable<User> getAllUsers(PaginateParam paginateParam);
}

