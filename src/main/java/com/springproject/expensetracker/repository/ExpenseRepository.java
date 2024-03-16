package com.springproject.expensetracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springproject.expensetracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
