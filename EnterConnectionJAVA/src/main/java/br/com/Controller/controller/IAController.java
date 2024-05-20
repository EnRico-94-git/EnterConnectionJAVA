package br.com.Controller.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.classes.model.IA;
import br.com.repository.repository.IARepository;

@RestController
@RequestMapping("/ias")
public class IAController {

    @Autowired
    private IARepository iaRepository;

    @GetMapping
    public List<IA> getAllIAs() {
        return iaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IA> getIAById(@PathVariable String id) {
        return iaRepository.findById(id)
                .map(ia -> ResponseEntity.ok().body(ia))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<IA> createIA(@RequestBody IA ia) {
        IA savedIA = iaRepository.save(ia);
        URI location = URI.create(String.format("/ias/%s", savedIA.getIdIa()));
        return ResponseEntity.created(location).body(savedIA);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IA> updateIA(@PathVariable String id, @RequestBody IA ia) {
        return iaRepository.findById(id)
                .map(existingIA -> {
                    ia.setIdIa(id);
                    IA updatedIA = iaRepository.save(ia);
                    return ResponseEntity.ok().body(updatedIA);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteIA(@PathVariable String id) {
        return iaRepository.findById(id)
                .map(ia -> {
                    iaRepository.delete(ia);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}