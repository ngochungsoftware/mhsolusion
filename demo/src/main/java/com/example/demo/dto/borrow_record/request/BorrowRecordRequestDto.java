package com.example.demo.dto.borrow_record.request;


import com.example.demo.infrastructure.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowRecordRequestDto
{
    private Set<Integer> users;
    private Set<Integer> books;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Status status;
}
