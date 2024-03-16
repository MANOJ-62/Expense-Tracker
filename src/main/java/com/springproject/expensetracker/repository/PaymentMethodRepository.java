package com.springproject.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springproject.expensetracker.model.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

	List<PaymentMethod> findByUserId(Long userId);
    // Add custom query methods if needed
}
