package br.com.enterconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.enterconnection.model.Parceiro;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro, String> {

}