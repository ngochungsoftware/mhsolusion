package com.example.demo.dto.borrow_record;

import java.io.Serializable;
import java.time.LocalDate;


public record BorrowRecordDto(
        Integer id,
        Integer userId,
        Integer bookId,
        LocalDate borrowDate,
        LocalDate returnDate,
        String status
) implements Serializable {}
