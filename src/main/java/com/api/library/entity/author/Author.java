package com.api.library.entity.author;

import com.api.library.entity.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@Entity
@Table(name = "tbl_author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author extends BaseModel {

    private static final long serialVersionUID = -3548797942204045837L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    public Author(@NonNull String firstName, @NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
