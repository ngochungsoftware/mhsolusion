package com.example.demo.repositories;

import com.example.demo.entities.BorrowRecord;
import com.example.demo.infrastructure.constant.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {
    List<BorrowRecord> findAllByStatusAndReturnDateBefore(Status status, LocalDate now);
}
