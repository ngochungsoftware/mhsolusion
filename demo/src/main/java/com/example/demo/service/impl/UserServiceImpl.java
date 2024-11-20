package com.example.demo.service.impl;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.entities.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.PaginateParam;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    @Transactional
    public UserDto save(UserCreateDto userCreateDto) {
        User user = userMapper.toEntity(userCreateDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserDto update(Integer id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        return userMapper.toDto(userRepository.save(userMapper.partialUpdate(userUpdateDto, user)));
    }

    @Override
    public UserDto getOne(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        return userMapper.toDto(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<UserDto> getAllUsers(PaginateParam paginateParam) {
        return userRepository.findAll(paginateParam.toPageRequest()).stream().map(userMapper::toDto).toList();
    }

}
