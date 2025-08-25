package com.maxsoftjs.practicandospring.repository;

import com.maxsoftjs.practicandospring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    // Buscar por username (lo necesitaremos para login)
    Optional<User> findByUsername(String username);
}
