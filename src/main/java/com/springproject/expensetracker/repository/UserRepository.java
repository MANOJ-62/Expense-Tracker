package com.springproject.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springproject.expensetracker.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsernameAndEmail(String username, String email);
    User findByUsername(String username);
}
