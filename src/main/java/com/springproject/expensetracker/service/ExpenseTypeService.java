package com.springproject.expensetracker.service;


import com.springproject.expensetracker.model.ExpenseType;
import java.util.List;

public interface ExpenseTypeService {
    ExpenseType createExpenseType(ExpenseType expenseType);
    List<ExpenseType> getAllExpenseTypes();
    // Other methods as needed
}
