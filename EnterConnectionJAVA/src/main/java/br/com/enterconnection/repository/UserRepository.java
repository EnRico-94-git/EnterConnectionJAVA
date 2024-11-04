package br.com.enterconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.enterconnection.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
