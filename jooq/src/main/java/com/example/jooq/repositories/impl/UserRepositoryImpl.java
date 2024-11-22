package com.example.jooq.repositories.impl;

import com.example.jooq.data.entity.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import com.example.jooq.generated.tables.records.UsersRecord;
import java.util.List;

import static com.example.jooq.generated.tables.Users.USERS;


@Repository
public class UserRepositoryImpl {
    private final DSLContext dslContext;

    public UserRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    // lấy tất cả danh sách người dùng
    public List<UsersRecord> getAllUsers() {
        return dslContext.selectFrom(USERS).fetchInto(UsersRecord.class);
    }

    // add
    public void addUser(User user) {
        UsersRecord record = dslContext.newRecord(USERS);
        record.setName(user.getName());
        record.setEmail(user.getEmail());
        record.setPhone(user.getPhone());
        record.setAddress(user.getAddress());
        record.insert();
    }

    // update
    public void updateUser(Integer id, User user) {
        dslContext.update(USERS)
                .set(USERS.NAME, user.getName())
                .set(USERS.EMAIL, user.getEmail())
                .set(USERS.PHONE, user.getPhone())
                .set(USERS.ADDRESS, user.getAddress())
                .where(USERS.ID.eq(id))
                .execute();
    }
    // delete
    public void deleteUser(Integer id) {
        dslContext.deleteFrom(USERS)
                .where(USERS.ID.eq(id))
                .execute();
    }

    // get one
    public User getUserById(Integer id) {
        return dslContext.selectFrom(USERS)
                .where(USERS.ID.eq(id))
                .fetchOneInto(User.class);

    }

}
