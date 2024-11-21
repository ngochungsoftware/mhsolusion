package com.example.demo.controller;


import com.example.demo.dto.borrow_record.request.BorrowRecordRequestDto;
import com.example.demo.dto.borrow_record.request.BorrowRecordRequestDtoV2;
import com.example.demo.entities.BorrowRecord;
import com.example.demo.service.BorrowRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/borrow_record")
public class BorrowRecordController {
    private final BorrowRecordService borrowRecordService;

    @PostMapping
    public ResponseEntity<String> saveBorrowRecord(@RequestBody @Valid BorrowRecordRequestDtoV2 borrowRecordRequestDtoV2) {
        BorrowRecord borrowRecord = borrowRecordService.createv2(borrowRecordRequestDtoV2);
        return ResponseEntity.status(HttpStatus.OK).body(borrowRecord.toString());
    }
}
