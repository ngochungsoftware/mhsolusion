package com.example.jooq.data.dtos.borrow_record;

import com.example.jooq.config.infrastructure.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowRecordDTO {
    private Set<Integer> users;
    private Set<Integer> books;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Status status;
}
