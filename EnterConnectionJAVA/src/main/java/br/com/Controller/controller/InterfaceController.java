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

import br.com.classes.model.Interface;
import br.com.repository.repository.InterfaceRepository;

@RestController
@RequestMapping("/interfaces")
public class InterfaceController {

    @Autowired
    private InterfaceRepository interfaceRepository;

    @GetMapping
    public List<Interface> getAllInterfaces() {
        return interfaceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interface> getInterfaceById(@PathVariable String id) {
        return interfaceRepository.findById(id)
                .map(interfaceEntity -> ResponseEntity.ok().body(interfaceEntity))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Interface> createInterface(@RequestBody Interface interfaceEntity) {
        Interface savedInterface = interfaceRepository.save(interfaceEntity);
        URI location = URI.create(String.format("/interfaces/%s", savedInterface.getIdInterface()));
        return ResponseEntity.created(location).body(savedInterface);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interface> updateInterface(@PathVariable String id, @RequestBody Interface interfaceEntity) {
        return interfaceRepository.findById(id)
                .map(existingInterface -> {
                    interfaceEntity.setIdInterface(id);
                    Interface updatedInterface = interfaceRepository.save(interfaceEntity);
                    return ResponseEntity.ok().body(updatedInterface);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInterface(@PathVariable String id) {
        return interfaceRepository.findById(id)
                .map(interfaceEntity -> {
                    interfaceRepository.delete(interfaceEntity);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}