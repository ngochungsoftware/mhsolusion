package com.example.demo.dto.borrow_record;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowRecordCreateDto implements Serializable {

    @NotNull(message = "User ID is required")
    private Integer userId;

    @NotNull(message = "Book ID is required")
    private Integer bookId;

    @NotNull(message = "Borrow date is required")
    @FutureOrPresent(message = "Borrow date cannot be in the past")
    private LocalDate borrowDate;

    private LocalDate returnDate;

    @NotNull(message = "Status is required")
    private String status; // Values: Borrowed, Returned, Overdue
}
