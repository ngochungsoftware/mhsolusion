package com.example.demo.entities;

import com.example.demo.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "genres")
public class Genre extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre", orphanRemoval = true)
    @ToString.Exclude
    private Set<Book> books = new LinkedHashSet<>();
}
