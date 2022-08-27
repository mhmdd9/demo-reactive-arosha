package com.arosha.reactivedemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PERSON")
@Data
public class Person {

    @Id
    private Integer id;

    private String name;
}
