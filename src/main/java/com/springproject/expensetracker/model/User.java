package com.springproject.expensetracker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password; // Encrypted
    private String firstName;
    private String lastName;
    private String email;
    private double monthlyIncome;
    private double currentBankBalance;
    private double currentCashBalance;
    private double currentCreditCardBalance;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public double getCurrentBankBalance() {
		return currentBankBalance;
	}
	public void setCurrentBankBalance(double currentBankBalance) {
		this.currentBankBalance = currentBankBalance;
	}
	public double getCurrentCashBalance() {
		return currentCashBalance;
	}
	public void setCurrentCashBalance(double currentCashBalance) {
		this.currentCashBalance = currentCashBalance;
	}
	public double getCurrentCreditCardBalance() {
		return currentCreditCardBalance;
	}
	public void setCurrentCreditCardBalance(double currentCreditCardBalance) {
		this.currentCreditCardBalance = currentCreditCardBalance;
	}

	 public User(Long id) {
	        this.id = id;
	    }
	 
	 public User() {
		    // Default constructor
		}
	 public List<PaymentMethod> getPaymentMethods() {
	        return paymentMethods;
	    }

}
