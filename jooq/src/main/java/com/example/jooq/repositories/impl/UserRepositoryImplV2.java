package com.example.jooq.repositories.impl;

import com.example.jooq.data.mappers.UserMapper;
import com.example.jooq.data.response.user.UserResponse;
import com.example.jooq.generated.tables.Users;
import com.example.jooq.generated.tables.records.UsersRecord;
import com.example.jooq.repositories.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImplV2 implements CrudRepository<UsersRecord> {

    private final DSLContext dsl;
    private final UserMapper userMapper;

    @Override
    public UsersRecord create(final UsersRecord usersRecord) {
        return dsl.insertInto(Users.USERS)
                .set(usersRecord)
                .set(Users.USERS.CREATED_AT, usersRecord.getCreatedAt())
                .returning()
                .fetchOne();
    }

    @Override
    public UsersRecord update(final UsersRecord usersRecord) {
        return dsl.update(Users.USERS)
                .set(dsl.newRecord(Users.USERS, usersRecord.getUpdatedAt()))
                .where(Users.USERS.ID.eq(usersRecord.getId()))
                .returning()
                .fetchOne();
    }

    @Override
    public UsersRecord findById(final Integer id) {
        return dsl.selectFrom(Users.USERS)
                .where(Users.USERS.ID.eq(id))
                .fetchOptional()
                .orElseThrow(() -> new NoSuchElementException("User with id " + id + " doesn't exist"));
    }


    @Override
    public Page<UsersRecord> search(Condition condition, Pageable pageable) {
        var records = dsl.selectFrom(Users.USERS)
                .where(condition)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch().into(UsersRecord.class);
        return new PageImpl<>(records);
    }



    @Override
    public Boolean deleteById(Integer id) {
        return dsl.deleteFrom(Users.USERS)
                .where(Users.USERS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }

    public List<UserResponse> getAllUsers() {
        return dsl.selectFrom(Users.USERS)
                .fetch()
                .map(record -> userMapper.toDto(record));
    }

}
