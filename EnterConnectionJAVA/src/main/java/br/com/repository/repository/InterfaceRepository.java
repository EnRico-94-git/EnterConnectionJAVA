package br.com.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.classes.model.Interface;

@Repository
public interface InterfaceRepository extends JpaRepository< Interface, String> {

}