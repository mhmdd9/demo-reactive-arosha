package com.arosha.reactivedemo.api;

import com.arosha.reactivedemo.dao.DocumentRepo;
import com.arosha.reactivedemo.dao.PersonDocumentRepo;
import com.arosha.reactivedemo.dao.PersonRepo;
import com.arosha.reactivedemo.model.Document;
import com.arosha.reactivedemo.model.Person;
import com.arosha.reactivedemo.model.PersonDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/person-document")
@RequiredArgsConstructor
public class PersonDocumentController {

    private final DocumentRepo documentRepo;
    private final PersonRepo personRepo;
    private final PersonDocumentRepo personDocumentRepo;

    @PostMapping("/save")
    void save(@RequestBody PersonDocument personDocument) {
        try {
            personDocumentRepo.save(
                    new PersonDocument(personDocument.getPersonId(), personDocument.getDocumentId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/find-all")
    Flux<PersonDocument> findAll() {
        return personDocumentRepo.findAll();
    }
}
