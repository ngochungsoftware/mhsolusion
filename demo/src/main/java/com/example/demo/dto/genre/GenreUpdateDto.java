package com.example.demo.dto.genre;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreUpdateDto implements Serializable {

    @NotBlank(message = "name is require")
    private String name;

}
