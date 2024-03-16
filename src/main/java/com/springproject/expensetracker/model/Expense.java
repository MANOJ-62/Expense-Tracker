package com.springproject.expensetracker.model;

import java.time.LocalDate;

import javax.persistence.Entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String description;
   private double amount;
   private LocalDate date;
   
   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;
   
   @ManyToOne
   @JoinColumn(name = "account_id")
   private PaymentMethod paymentMethod;
   
   @ManyToOne
   @JoinColumn(name = "expense_type_id")
   private ExpenseType expenseType;
   
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
   
}
