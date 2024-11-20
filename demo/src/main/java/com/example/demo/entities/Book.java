package com.example.demo.entities;

import com.example.demo.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "cloudinary_image_id")
    private String cloudinaryImageId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer available;
}
