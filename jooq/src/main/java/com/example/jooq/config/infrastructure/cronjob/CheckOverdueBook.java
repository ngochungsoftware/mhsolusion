package com.example.jooq.config.infrastructure.cronjob;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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