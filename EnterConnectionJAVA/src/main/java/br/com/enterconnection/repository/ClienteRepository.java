package br.com.enterconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.enterconnection.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    
}