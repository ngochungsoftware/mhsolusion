package com.example.demo.dto.user;


import jakarta.validation.constraints.Email;
import java.io.Serializable;


public record UserDto(Integer id, String name,
                      @Email(message = "Email is not valid") String email,
                      String phone , String address) implements Serializable {
}
