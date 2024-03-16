package com.springproject.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.expensetracker.model.Expense;
import com.springproject.expensetracker.repository.ExpenseRepository;

//@Service
//public class ExpenseService {
//
//	@Autowired
//	private ExpenseRepository repository;
//	
//	public List<Expense> findall(){
//		return repository.findAll();
//		}
//	
//	public void save(Expense expense) {
//		repository.save(expense);
//	}
//	
//	public void delete(Expense expense) {
//		repository.delete(expense);
//	}
//
//	public Expense findById(Long id) {
//		return repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid expense ID"));
//	}
//
//
//	public void delete(Long id) {
//		// TODO Auto-generated method stub
//		repository.deleteById(id);
//		
//	}
//
//	public void update(Long id, Expense expense) {
//		// TODO Auto-generated method stub
//		Expense existingExpense=findById(id);
//		existingExpense.setDescription(expense.getDescription());
//		existingExpense.setAmount(expense.getAmount());
//		existingExpense.setDate(expense.getDate());
//		repository.save(existingExpense);
//		
//	}
//}


import com.springproject.expensetracker.model.Expense;
import java.util.List;

public interface ExpenseService {
    Expense createExpense(Expense expense); // Corrected method signature
    Expense updateExpense(Expense expense); // Corrected method signature
    void deleteExpense(Long id); // Corrected method signature
    List<Expense> getAllExpenses(); // Corrected method signature
}

