package com.example.demo.controller;


import com.example.demo.dto.user.request.UserRequestDto;
import com.example.demo.entities.User;
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
    public Iterable<User> getAllUsers(PaginateParam paginateParam) {
        return userService.getAllUsers(paginateParam);
    }

    @PostMapping("/save")
    public User createUser(@RequestBody @Valid UserRequestDto userCreateDto) {
        return userService.save(userCreateDto);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getOne(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Integer id,
                                                           @RequestBody @Valid UserRequestDto userUpdateDto) {
        User User = userService.update(id, userUpdateDto);
        ApiResponse<User> response = new ApiResponse<>("User updated successfully", User, 201);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<User>> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("User deleted successfully", null, 204));
    }

}
