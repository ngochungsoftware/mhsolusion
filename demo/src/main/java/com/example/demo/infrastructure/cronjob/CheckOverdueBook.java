package com.example.demo.infrastructure.cronjob;

import com.example.demo.entities.Book;
import com.example.demo.entities.BorrowRecord;
import com.example.demo.entities.User;
import com.example.demo.infrastructure.constant.Status;
import com.example.demo.repositories.BorrowRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CheckOverdueBook {

//    private final BorrowRecordRepository borrowRecordRepository;
//
//    @Scheduled(cron = "0 0 0 * * ?")
//    public void checkOverdueBooks() {
//        List<BorrowRecord> overdueRecords = borrowRecordRepository.findAllByStatusAndReturnDateBefore(Status.BORROWED, LocalDate.now());
//
//        for (BorrowRecord record : overdueRecords) {
//            record.setStatus(Status.OVERDUE);
//            borrowRecordRepository.save(record);
//
//            User user = record.getUser();
//            for (Book book : record.getBook()) {
//                notificationService.sendNotification(
//                        user.getEmail(),
//                        "Book overdue",
//                        "The book " + book.getTitle() + " is overdue. Please return it as soon as possible."
//                );
//            }
//        }
//    }
}