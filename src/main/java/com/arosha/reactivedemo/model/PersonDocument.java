package com.arosha.reactivedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PERSON_DOCUMENT")
@Data
@AllArgsConstructor
public class PersonDocument {

    @Column("PERSON_ID")
    private Integer personId;

    @Column("DOCUMENT_ID")
    private Integer documentId;
}
