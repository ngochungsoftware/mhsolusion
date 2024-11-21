package com.example.demo.service;

import com.example.demo.dto.borrow_record.request.BorrowRecordRequestDto;
import com.example.demo.dto.borrow_record.request.BorrowRecordRequestDtoV2;
import com.example.demo.entities.BorrowRecord;

public interface BorrowRecordService {

//    BorrowRecord create(BorrowRecordRequestDto borrowRecordRequestDto);

    BorrowRecord createv2(BorrowRecordRequestDtoV2 borrowRecordRequestDtoV2);
}
