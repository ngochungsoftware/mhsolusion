package com.example.demo.controller;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.infrastructure.common.ApiResponse;
import com.example.demo.models.PaginateParam;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @GetMapping
    public Iterable<UserDto> getAllUsers(PaginateParam paginateParam) {
        return userService.getAllUsers(paginateParam);
    }

    @PostMapping("/save")
    public UserDto createUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        return userService.save(userCreateDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.getOne(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponse<UserDto>> updateUser(@PathVariable Integer id,
                                                           @RequestBody @Valid UserUpdateDto userUpdateDto) {
        UserDto userDto = userService.update(id, userUpdateDto);
        ApiResponse<UserDto> response = new ApiResponse<>("User updated successfully", userDto, 201);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<UserDto>> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("User deleted successfully", null, 204));
    }

}
