package com.example.demo.service.impl;

import com.example.demo.dto.borrow_record.request.BorrowRecordRequestDtoV2;
import com.example.demo.entities.Book;
import com.example.demo.entities.BorrowRecord;
import com.example.demo.entities.User;
import com.example.demo.infrastructure.constant.Status;
import com.example.demo.mapper.BorrowRecordMapper;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.BorrowRecordRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.BorrowRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final BorrowRecordMapper borrowRecordMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

//    @Override
//    public BorrowRecord create(BorrowRecordRequestDto borrowRecordRequestDto) {
//        BorrowRecord borrowRecord = borrowRecordMapper.toEntity(borrowRecordRequestDto);
//
//        Set<Integer> idUser = borrowRecordRequestDto.getUsers();
//        Set<User> listUser = new HashSet<>();
//        for (Integer userId : idUser) {
//            User user = userRepository.findById(userId).orElseThrow(
//                    () -> new RuntimeException("User with id " + userId + " not found"));
//            listUser.add(user);
//        }
//        for (User x : listUser) {
//            borrowRecord.setUser(x);
//        }
//
//        Set<Integer> idBook = borrowRecordRequestDto.getBooks();
//        Set<Book> listBook = new HashSet<>();
//        for (Integer bookid : idBook) {
//            Book book = bookRepository.findById(bookid).orElseThrow(
//                    () -> new RuntimeException("Book with id " + bookid + " not found"));
//            listBook.add(book);
//        }
//
//        for (Book x : listBook) {
//            borrowRecord.setBook(x);
//        }
//
//        return borrowRecordRepository.save(borrowRecord);
//    }

    // tối ưu

//    @Override
//    public BorrowRecord create(BorrowRecordRequestDto borrowRecordRequestDto) {
//        BorrowRecord borrowRecord = borrowRecordMapper.toEntity(borrowRecordRequestDto);
//        Set<User> listUser = userRepository.findAllById(borrowRecordRequestDto.getUsers())
//                .orElseThrow(() -> new RuntimeException("Users not found"));
//        borrowRecord.setUsers(listUser);
//        Set<Book> listBook = bookRepository.findAllById(borrowRecordRequestDto.getBooks())
//                .orElseThrow(() -> new RuntimeException("Books not found"));
//        borrowRecord.setBooks(listBook);
//        return borrowRecordRepository.save(borrowRecord);
//    }

    @Override
    public BorrowRecord createv2(BorrowRecordRequestDtoV2 borrowRecordRequestDtoV2) {
        BorrowRecord borrowRecord = borrowRecordMapper.toEntity(borrowRecordRequestDtoV2);

        Set<User> users = new HashSet<>(userRepository.findAllById(borrowRecordRequestDtoV2.getUsers()));
        if (users.isEmpty()) {
            throw new RuntimeException("Users not found");
        }


        Set<Book> books = new HashSet<>();
       for (Map.Entry<Integer, Integer> entry : borrowRecordRequestDtoV2.getBooks().entrySet()) {
            Integer bookid = entry.getKey();
            Integer borrowQuantity = entry.getValue();
            Book book = bookRepository.findById(bookid)
                    .orElseThrow(() -> new RuntimeException("Book with id " + bookid + " not found"));
            if (book.getAvailable() < borrowQuantity) {
                throw new RuntimeException("Book "+ book.getTitle() + "does not enough available");
            }
            book.setAvailable(book.getAvailable() - borrowQuantity);
            books.add(book);
            bookRepository.save(book);
       }

       for (User user : users) {
           borrowRecord.setUser(user);
       }
       for (Book book : books) {
           borrowRecord.setBook(book);
       }
       return borrowRecordRepository.save(borrowRecord);
    }

    public BorrowRecord returnBooks(Integer borrowRecordId, Map<Integer, Integer> returnQuantities) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(borrowRecordId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        for (Map.Entry<Integer, Integer> entry : returnQuantities.entrySet()) {
            Integer bookId = entry.getKey();
            Integer returnQuantity = entry.getValue();

            Book book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new RuntimeException("Book with id " + bookId + " not found"));

            int updatedAvailable = book.getAvailable() + returnQuantity;
            if (updatedAvailable > book.getQuantity()) {
                throw new RuntimeException("Return quantity exceeds total available for book " + book.getTitle());
            }

            book.setAvailable(updatedAvailable);
            bookRepository.save(book);
        }

        borrowRecord.setStatus(Status.RETURNED);
        borrowRecord.setReturnDate(LocalDate.now());

        return borrowRecordRepository.save(borrowRecord);
    }



}
