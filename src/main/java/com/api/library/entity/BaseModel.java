package com.api.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/
@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Version
    private Integer version;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="modified_date")
    private Date modifiedDate;

    @PrePersist
    public void prePersist() {
        createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDate = new Date();
    }
}
