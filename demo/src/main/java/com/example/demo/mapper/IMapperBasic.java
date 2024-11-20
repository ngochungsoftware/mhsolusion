package com.example.demo.mapper;

import java.util.List;

public interface IMapperBasic<E, D> {
    E toEntity(D d);

    List<E> toListEntity(List<D> d);

    D toDTO(E e);

    List<D> toListDTO(List<E> e);
}
