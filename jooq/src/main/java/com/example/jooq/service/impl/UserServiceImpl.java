package com.example.jooq.service.impl;

import com.example.jooq.data.dtos.user.UserDTO;
import com.example.jooq.data.entity.User;
import com.example.jooq.data.mappers.UserMapper;
import com.example.jooq.data.request.user.UserRequest;
import com.example.jooq.data.response.user.UserResponse;
import com.example.jooq.generated.tables.records.UsersRecord;
import com.example.jooq.repositories.impl.UserRepositoryImplV2;
import com.example.jooq.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepositoryImplV2 userRepositoryImplV2;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepositoryImplV2.getAllUsers();
    }

    @Override
    public void addUser(UserRequest userRequest) {
        // Chuyển từ UserRequest sang User entity
        User user = userMapper.toEntity(userRequest);
        // Chuyển từ User sang UsersRecord (JOOQ record)
        UsersRecord usersRecord = userMapper.toRecord(user);
        usersRecord.setCreatedAt(LocalDateTime.now());
        userRepositoryImplV2.create(usersRecord);
    }

    @Override
    public void updateUser(Integer id, UserRequest userRequest) {
        UsersRecord existingRecord = userRepositoryImplV2.findById(id);
        User existingUser = userMapper.toEntity(existingRecord);
        User updatedUser = userMapper.partialUpdate(userRequest, existingUser);
        UsersRecord updatedRecord = userMapper.toRecord(updatedUser);
        updatedRecord.setId(id);
        userRepositoryImplV2.update(updatedRecord);
    }

    @Override
    public void deleteUser(Integer id) {
        // First check if user exists to throw NoSuchElementException if not found
        userRepositoryImplV2.findById(id);
        userRepositoryImplV2.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserById(Integer id) {
        UsersRecord usersRecord = userRepositoryImplV2.findById(id);
        User user = userMapper.toEntity(usersRecord);
        return userMapper.toDto(user);
    }
}