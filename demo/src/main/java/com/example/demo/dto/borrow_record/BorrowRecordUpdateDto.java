package com.example.demo.dto.borrow_record;

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
public class BorrowRecordUpdateDto implements Serializable {

    @NotNull(message = "Borrow record ID is required")
    private Integer id;

    private LocalDate returnDate;

    @NotNull(message = "Status is required")
    private String status; // Values: Borrowed, Returned, Overdue
}
