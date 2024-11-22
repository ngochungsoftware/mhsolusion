package com.example.jooq.repositories;

import org.jooq.Condition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudRepository<T> {

    Integer SUCCESS_CODE = 1;

    T create(T t);

    T update(T t);

    T findById(Integer id);

    Page<T> search(Condition condition, Pageable pageable); // tình trạng

    Boolean deleteById(Integer id);

}
