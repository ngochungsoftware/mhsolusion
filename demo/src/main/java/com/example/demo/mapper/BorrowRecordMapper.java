package com.example.demo.mapper;


import com.example.demo.dto.borrow_record.BorrowRecordCreateDto;
import com.example.demo.dto.borrow_record.BorrowRecordDto;
import com.example.demo.dto.borrow_record.BorrowRecordUpdateDto;
import com.example.demo.entities.BorrowRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {BookMapper.class, UserMapper.class})
public interface BorrowRecordMapper {

    BorrowRecord toEntity(BorrowRecordDto borrowRecordDto);

    BorrowRecord toDto(BorrowRecord borrowRecord);

    BorrowRecord toEntity(BorrowRecordCreateDto borrowRecordCreateDto);

    BorrowRecordCreateDto toCreateDto(BorrowRecord borrowRecord);

    BorrowRecord toEntity(BorrowRecordUpdateDto borrowRecordUpdateDto);

    BorrowRecordUpdateDto toUpdateDto(BorrowRecord borrowRecord);
}
