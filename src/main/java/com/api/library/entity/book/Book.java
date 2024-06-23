package com.api.library.entity.book;

import com.api.library.entity.BaseModel;
import com.api.library.entity.author.Author;
import jakarta.persistence.*;
import lombok.*;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@Entity
@Table(name = "tbl_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseModel {

    private static final long serialVersionUID = -3548797942204045837L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "name" ,nullable=false)
    private String name;

    @NonNull
    @Column(name = "isbn" ,nullable=false ,unique = true)
    private String isbn;

    @NonNull
    @JoinColumn(name = "author_id" ,nullable=false)
    @ManyToOne(targetEntity = Author.class,fetch = FetchType.LAZY)
    private Author author;

    public Book(@NonNull String name, @NonNull String isbn, @NonNull Author author) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
    }
}
