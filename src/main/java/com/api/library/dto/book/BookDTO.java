package com.api.library.dto.book;

import com.api.library.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class BookDTO extends BaseDTO {

    private String name;
    private String isbn;
    private Integer authorId;
    private String authorName;
}
