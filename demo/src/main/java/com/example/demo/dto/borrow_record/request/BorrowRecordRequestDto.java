package com.example.demo.dto.borrow_record.request;


import com.example.demo.entities.Book;
import com.example.demo.entities.User;
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
    private Set<User> users;
    private Set<Book> books;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Status status;
}
