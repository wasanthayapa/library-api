package com.api.library.dto.author;

import com.api.library.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorDTO extends BaseDTO {

    private String firstName;
    private String lastName;
}
