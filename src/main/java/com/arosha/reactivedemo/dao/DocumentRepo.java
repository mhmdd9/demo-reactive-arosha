package com.arosha.reactivedemo.dao;

import com.arosha.reactivedemo.model.Document;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends ReactiveCrudRepository<Document, Integer> {
}
