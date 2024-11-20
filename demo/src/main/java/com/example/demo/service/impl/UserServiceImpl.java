package com.example.demo.service.impl;


import com.example.demo.dto.user.request.UserRequestDto;
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
    public User save(UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(Integer id, UserRequestDto userUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        user.setName(userUpdateDto.getName());
        user.setEmail(userUpdateDto.getEmail());
        user.setPhone(userUpdateDto.getPhone());
        return userRepository.save(user);
    }

    @Override
    public User getOne(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<User> getAllUsers(PaginateParam paginateParam) {
        return userRepository.findAll(paginateParam.toPageRequest()).stream().toList();
    }

}
