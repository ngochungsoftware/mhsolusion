package com.example.demo.dto.author;

import java.io.Serializable;

public record AuthorDto(Integer id,
                        String name,
                        Integer birthYear,
                        String nationality) implements Serializable {
}
