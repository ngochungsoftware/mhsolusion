package com.example.demo.dto.author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * DTO for updating an existing author.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorUpdateDto implements Serializable {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Birth year is required")
    private Integer birthYear;

    @NotBlank(message = "Nationality is required")
    @Length(max = 100, message = "Nationality should not exceed 100 characters")
    private String nationality;
}
