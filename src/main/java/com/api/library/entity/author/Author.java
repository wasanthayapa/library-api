package com.api.library.entity.author;

import com.api.library.entity.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@Entity
@Table(name = "tbl_author")
@Getter
@Setter
public class Author extends BaseModel {

    private static final long serialVersionUID = -3548797942204045837L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "authors_s")
    @SequenceGenerator(name = "authors_s", sequenceName = "authors_s", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name ")
    private String firstName;

    @Column(name = "last_name ")
    private String lastName;
}
