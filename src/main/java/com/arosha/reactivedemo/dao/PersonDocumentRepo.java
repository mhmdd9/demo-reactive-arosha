package com.arosha.reactivedemo.dao;

import com.arosha.reactivedemo.model.PersonDocument;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDocumentRepo extends ReactiveCrudRepository<PersonDocument, Integer> {
}
