package com.example.jooq.service;

import com.example.jooq.data.dtos.user.UserDTO;
import com.example.jooq.data.request.user.UserRequest;
import com.example.jooq.data.response.user.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();

    void addUser(UserRequest userRequest);

    void updateUser(Integer id, UserRequest userRequest);

    void deleteUser(Integer id);

    UserDTO getUserById(Integer id);

}
