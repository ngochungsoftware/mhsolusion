package com.example.demo.entities;


import com.example.demo.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "authors",uniqueConstraints = @UniqueConstraint(columnNames = { "nationality"}))
public class Author extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column
    private String nationality;
}
