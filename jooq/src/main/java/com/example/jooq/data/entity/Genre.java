package com.example.jooq.data.entity;

import com.example.jooq.data.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "genres")
public class Genre extends BaseEntity {

    @Column(nullable = false)
    private String name;

}
