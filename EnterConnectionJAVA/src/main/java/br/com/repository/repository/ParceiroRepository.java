package br.com.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.classes.model.Parceiro;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro, String> {
}
