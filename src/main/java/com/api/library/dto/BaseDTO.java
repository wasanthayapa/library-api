package com.api.library.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BaseDTO {

    private Integer id;
    private Integer version;
}
