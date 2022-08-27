package com.arosha.reactivedemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("DOCUMENT")
@Data
public class Document {

    @Id
    private Integer id;

    private String name;
    private String code;
}
