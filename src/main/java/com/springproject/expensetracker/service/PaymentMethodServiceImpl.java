package com.springproject.expensetracker.service;

import com.springproject.expensetracker.model.PaymentMethod;
import com.springproject.expensetracker.model.User;
import com.springproject.expensetracker.repository.PaymentMethodRepository;
import com.springproject.expensetracker.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    @Autowired
    private UserRepository userRepository;
//    @Override
//    public PaymentMethod createPaymentMethod(Long userId, PaymentMethod paymentMethod) {
//        // Find the user by userId
//        Optional<User> optionalUser = userRepository.findById(userId);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            paymentMethod.setUser(user);
//            user.addPaymentMethod(paymentMethod);
//            userRepository.save(user);
//            return paymentMethodRepository.save(paymentMethod);
//        } else {
//            throw new RuntimeException("User not found with id: " + userId);
//        }
//    }

    @Override
    public PaymentMethod createPaymentMethod(Long userId, PaymentMethod paymentMethod) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Check if a similar payment method already exists for the user
            boolean paymentMethodExists = user.getPaymentMethods().stream()
                    .anyMatch(pm -> pm.getPaymentType().equals(paymentMethod.getPaymentType())
                            && pm.getName().equals(paymentMethod.getName())
                            && pm.getBalance() == paymentMethod.getBalance());

            if (paymentMethodExists) {
                throw new RuntimeException("Payment method already exists for the user");
            }

            // Add the new payment method
            user.addPaymentMethod(paymentMethod);
            userRepository.save(user);
            return paymentMethod;
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
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
    public User getUserWithPaymentMethods(Long userId) {
        return userRepository.findByIdWithPaymentMethods(userId);
    }

    @Override
    public List<PaymentMethod> getAllPaymentMethodsByUserId(Long userId) {
        return paymentMethodRepository.findByUserId(userId);
    }

}
