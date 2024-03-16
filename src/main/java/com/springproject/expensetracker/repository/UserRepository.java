package com.springproject.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springproject.expensetracker.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsernameAndEmail(String username, String email);
    User findByUsername(String username);

//    User findByUsername(@Param("username") String username);
    @Query("SELECT u FROM User u JOIN FETCH u.paymentMethods WHERE u.id = :userId")
    User findByIdWithPaymentMethods(@Param("userId") Long userId);
}
