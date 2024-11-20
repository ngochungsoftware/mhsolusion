package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaginateParam {
    int page;
    @Builder.Default
    int size = 10;

    @Builder.Default
    String sortBy = "updatedAt";

    @Builder.Default
    Sort.Direction direction = Sort.DEFAULT_DIRECTION;

    public PageRequest toPageRequest() {
        return PageRequest.of(page, size, Sort.by(direction, sortBy));
    }
}
