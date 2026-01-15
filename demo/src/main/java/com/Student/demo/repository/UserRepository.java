package com.Student.demo.repository;

import com.Student.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // This MUST return Optional<User> to match the Service logic
    Optional<User> findByUsername(String username);
}