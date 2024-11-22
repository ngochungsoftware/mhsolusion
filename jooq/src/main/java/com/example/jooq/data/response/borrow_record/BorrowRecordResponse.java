package com.example.jooq.data.response.borrow_record;

import com.example.jooq.config.infrastructure.constant.Status;

import java.time.LocalDate;
import java.util.Set;

public class BorrowRecordResponse {

    private Set<Integer> users;
    private Set<Integer> books;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Status status;
}
