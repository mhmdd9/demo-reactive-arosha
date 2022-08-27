package com.arosha.reactivedemo.api;

import com.arosha.reactivedemo.dao.PersonRepo;
import com.arosha.reactivedemo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepo repo;

    @GetMapping("/find-all")
    Flux<Person> findAll() {
        return repo.findAll();
    }

    @GetMapping("/person/{id}")
    Mono<Person> findById(@PathVariable Integer id) {
        return repo.findById(id);
    }

    @PostMapping
    Mono<Person> save(@RequestBody Person person) {
        return repo.save(person);
    }


    @PutMapping("/update/{id}")
    private Mono<Person> updatePerson(@PathVariable Integer id,
                                      @RequestBody Person person) {
        return repo.findById(id).flatMap(p -> {
            person.setId(id);
            return repo.save(person);
        }).switchIfEmpty(Mono.empty());
    }

    @DeleteMapping("/delete/{id}")
    Mono<Void> deleteById(@PathVariable Integer id) {
        return repo.findById(id).flatMap(p ->
                repo.deleteById(p.getId()));
    }
}
