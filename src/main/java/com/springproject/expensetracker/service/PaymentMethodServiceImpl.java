package com.springproject.expensetracker.service;

import com.springproject.expensetracker.model.PaymentMethod;
import com.springproject.expensetracker.model.User;
import com.springproject.expensetracker.repository.PaymentMethodRepository;
import com.springproject.expensetracker.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public PaymentMethod createPaymentMethod(Long userId, PaymentMethod paymentMethod) {
//        paymentMethod.setUser(new User(userId));
//        return paymentMethodRepository.save(paymentMethod);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        
        // Associate the fetched user with the payment method
        paymentMethod.setUser(user);
        
        // Save and return the payment method with the user association
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void deletePaymentMethod(Long id) {
        paymentMethodRepository.deleteById(id);
    }

	@Override
	public List<PaymentMethod> getAllPaymentMethodsByUserId(Long userId) {
        return paymentMethodRepository.findByUserId(userId);
    }
	
}
