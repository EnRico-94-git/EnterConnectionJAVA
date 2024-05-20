package br.com.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.classes.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
