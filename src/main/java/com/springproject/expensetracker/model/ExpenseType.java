package com.springproject.expensetracker.model;

import java.time.LocalDate;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExpenseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName; // Bank Account, Credit Card, Cash
    private boolean isCreditCard; // To identify credit card expenses
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public boolean isCreditCard() {
		return isCreditCard;
	}
	public void setCreditCard(boolean isCreditCard) {
		this.isCreditCard = isCreditCard;
	}
    
    // Getters and setters
}
