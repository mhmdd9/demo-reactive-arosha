package com.arosha.reactivedemo.dao;

import com.arosha.reactivedemo.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends ReactiveCrudRepository<Person, Integer> {
}
