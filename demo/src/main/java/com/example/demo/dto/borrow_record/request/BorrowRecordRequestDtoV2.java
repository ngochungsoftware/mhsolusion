package com.example.demo.dto.borrow_record.request;

import com.example.demo.infrastructure.constant.Status;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowRecordRequestDtoV2
{
    private Set<Integer> users;
    private Map<Integer, Integer> books; // key : bookid , value : so luong
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Status status;
}
