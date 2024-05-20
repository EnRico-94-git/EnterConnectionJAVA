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

import br.com.classes.model.Parceiro;
import br.com.repository.repository.ParceiroRepository;

@RestController
@RequestMapping("/parceiros")
public class ParceiroController {

    @Autowired
    private ParceiroRepository parceiroRepository;

    @GetMapping
    public List<Parceiro> getAllParceiros() {
        return parceiroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parceiro> getParceiroById(@PathVariable String id) {
        return parceiroRepository.findById(id)
                .map(parceiro -> ResponseEntity.ok().body(parceiro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Parceiro> createParceiro(@RequestBody Parceiro parceiro) {
        Parceiro savedParceiro = parceiroRepository.save(parceiro);
        URI location = URI.create(String.format("/parceiros/%s", savedParceiro.getIdParceiro()));
        return ResponseEntity.created(location).body(savedParceiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parceiro> updateParceiro(@PathVariable String id, @RequestBody Parceiro parceiro) {
        return parceiroRepository.findById(id)
                .map(existingParceiro -> {
                    parceiro.setIdParceiro(id);
                    Parceiro updatedParceiro = parceiroRepository.save(parceiro);
                    return ResponseEntity.ok().body(updatedParceiro);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParceiro(@PathVariable String id) {
        return parceiroRepository.findById(id)
                .map(parceiro -> {
                    parceiroRepository.delete(parceiro);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}