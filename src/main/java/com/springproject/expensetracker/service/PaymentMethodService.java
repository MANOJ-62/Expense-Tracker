package com.springproject.expensetracker.service;

import java.util.List;

import com.springproject.expensetracker.model.PaymentMethod;
import com.springproject.expensetracker.model.User;

public interface PaymentMethodService {
    PaymentMethod createPaymentMethod(Long userId, PaymentMethod paymentMethod);
    PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);
    void deletePaymentMethod(Long id);
	List<PaymentMethod> getAllPaymentMethodsByUserId(Long userId);

    User getUserWithPaymentMethods(Long userId);
}
