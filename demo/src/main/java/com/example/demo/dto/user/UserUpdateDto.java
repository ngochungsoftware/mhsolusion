package com.example.demo.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDto implements Serializable {
    @NotBlank(message = "Name is require")
    private String name;

    @NotBlank(message = "Email is require")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank
    @Length(min = 10)
    private String phone;
}
