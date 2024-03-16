package com.springproject.expensetracker.service;

import com.springproject.expensetracker.model.Expense;
import com.springproject.expensetracker.repository.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense createExpense(Expense expense) {
        // Implement create expense logic here
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        // Implement update expense logic here
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        // Implement delete expense logic here
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Expense> getAllExpenses() {
        // Implement get all expenses logic here
        return expenseRepository.findAll();
    }
}
