package com.example.demo.mapper;


import com.example.demo.dto.borrow_record.request.BorrowRecordRequestDto;
import com.example.demo.dto.borrow_record.request.BorrowRecordRequestDtoV2;
import com.example.demo.entities.BorrowRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {BookMapper.class, UserMapper.class})
public interface BorrowRecordMapper extends IMapperBasic<BorrowRecord , BorrowRecordRequestDtoV2> {

}
