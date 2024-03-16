package com.springproject.expensetracker.dto;

import java.util.List;

public class UserWithPaymentMethodsDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private double monthlyIncome;
    private double currentBankBalance;
    private double currentCashBalance;
    private double currentCreditCardBalance;
    private List<PaymentMethodDTO> paymentMethods;
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
	public List<PaymentMethodDTO> getPaymentMethods() {
		return paymentMethods;
	}
	public void setPaymentMethods(List<PaymentMethodDTO> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

    // Constructors, getters, and setters
}

