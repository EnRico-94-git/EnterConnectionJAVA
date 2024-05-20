package br.com.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.classes.model.IA;

@Repository
public interface IARepository extends JpaRepository<IA, String> {
}