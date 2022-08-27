package com.arosha.reactivedemo.api;

import com.arosha.reactivedemo.dao.DocumentRepo;
import com.arosha.reactivedemo.model.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentRepo repo;

    @GetMapping("/find-all")
    Flux<Document> findAll() {
        return repo.findAll();
    }

    @GetMapping("/document/{id}")
    Mono<Document> findById(@PathVariable Integer id) {
        return repo.findById(id);
    }

    @PostMapping
    Mono<Document> save(@RequestBody Document document) {
        return repo.save(document);
    }


    @PutMapping("/update/{id}")
    private Mono<Document> updateDocument(@PathVariable Integer id,
                                      @RequestBody Document document) {
        return repo.findById(id).flatMap(d -> {
            document.setId(id);
            return repo.save(document);
        }).switchIfEmpty(Mono.empty());
    }

    @DeleteMapping("/delete/{id}")
    Mono<Void> deleteById(@PathVariable Integer id) {
        return repo.findById(id).flatMap(p ->
                repo.deleteById(p.getId()));
    }
}
