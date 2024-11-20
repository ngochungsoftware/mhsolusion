package com.example.demo.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto implements Serializable {

    @NotBlank(message = "Name is require")
    private String name;

    @NotBlank(message = "Email is require")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank
    @Length(min = 10)
    private String phone;

    private String address;
}
