package com.springproject.expensetracker.service;

import java.util.List;

import com.springproject.expensetracker.model.PaymentMethod;

public interface PaymentMethodService {
    PaymentMethod createPaymentMethod(Long userId, PaymentMethod paymentMethod);
    PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);
    void deletePaymentMethod(Long id);
	List<PaymentMethod> getAllPaymentMethodsByUserId(Long userId);
}
