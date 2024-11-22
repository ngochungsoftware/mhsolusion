package com.example.jooq.controller;


import com.example.jooq.data.dtos.user.UserDTO;
import com.example.jooq.data.request.user.UserRequest;
import com.example.jooq.data.response.user.UserResponse;
import com.example.jooq.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        try {
            List<UserResponse> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            logger.error("Error fetching all users", e);
            throw new RuntimeException("Error fetching all users.", e);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Void> addUser(@RequestBody @Valid UserRequest userRequest) {
        try {
            logger.info("Adding new user: {}", userRequest);
            userService.addUser(userRequest);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            logger.error("Error saving user: {}", userRequest, e);
            throw new RuntimeException("Error saving user.", e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody @Valid UserRequest userRequest) {
        try {
            logger.info("Updating user with ID {}: {}", id, userRequest);
            userService.updateUser(id, userRequest);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error updating user with ID {}: {}", id, userRequest, e);
            throw new RuntimeException("Error updating user.", e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable @Valid Integer id) {
        try {
            logger.info("Deleting user with ID {}", id);
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting user with ID {}", id, e);
            throw new RuntimeException("Error deleting user.", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable @Valid Integer id) {
        try {
            logger.info("Fetching user with ID {}", id);
            UserDTO user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("Error fetching user with ID {}", id, e);
            throw new RuntimeException("Error fetching user by ID.", e);
        }
    }
}
