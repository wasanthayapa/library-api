package com.api.library.entity.book;

import com.api.library.entity.BaseModel;
import com.api.library.entity.author.Author;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@Entity
@Table(name = "tbl_book")
@Getter
@Setter
public class Book extends BaseModel {

    private static final long serialVersionUID = -3548797942204045837L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "book_s")
    @SequenceGenerator(name = "book_s", sequenceName = "book_s", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name  ")
    private String name;

    @Column(name = "isbn")
    private String isbn;

    @JoinColumn(name = "author_id")
    @ManyToOne(targetEntity = Author.class,fetch = FetchType.LAZY)
    private Author author;
}
