package com.example.demo.service.impl;

import com.example.demo.dto.borrow_record.request.BorrowRecordRequestDto;
import com.example.demo.entities.Book;
import com.example.demo.entities.BorrowRecord;
import com.example.demo.entities.User;
import com.example.demo.mapper.BorrowRecordMapper;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.BorrowRecordRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.BorrowRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final BorrowRecordMapper borrowRecordMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public BorrowRecord create(BorrowRecordRequestDto borrowRecordRequestDto) {
        BorrowRecord borrowRecord = borrowRecordMapper.toEntity(borrowRecordRequestDto);

        Set<Integer> idUser = borrowRecordRequestDto.getUsers();
        Set<User> listUser = new HashSet<>();
        for (Integer userId : idUser) {
            User user = userRepository.findById(userId).orElseThrow(
                    () -> new RuntimeException("User with id " + userId + " not found"));
            listUser.add(user);
        }
        for (User x : listUser) {
            borrowRecord.setUser(x);
        }

        Set<Integer> idBook = borrowRecordRequestDto.getBooks();
        Set<Book> listBook = new HashSet<>();
        for (Integer bookid : idBook) {
            Book book = bookRepository.findById(bookid).orElseThrow(
                    () -> new RuntimeException("Book with id " + bookid + " not found"));
            listBook.add(book);
        }

        for (Book x : listBook) {
            borrowRecord.setBook(x);
        }

        return borrowRecordRepository.save(borrowRecord);
    }


}
