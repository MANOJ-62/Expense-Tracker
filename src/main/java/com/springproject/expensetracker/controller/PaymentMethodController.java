package com.springproject.expensetracker.controller;

import com.springproject.expensetracker.model.PaymentMethod;
import com.springproject.expensetracker.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;
    
    @GetMapping("/{userId}")
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethods(@PathVariable Long userId) {
        // Assuming you have a method in service to fetch all payment methods by user ID
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllPaymentMethodsByUserId(userId);
        return ResponseEntity.ok(paymentMethods);
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<PaymentMethod> createPaymentMethod(@PathVariable Long userId, @RequestBody PaymentMethod paymentMethod) {
        PaymentMethod newPaymentMethod = paymentMethodService.createPaymentMethod(userId, paymentMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaymentMethod);
    }

    @PutMapping("/update")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        PaymentMethod updatedPaymentMethod = paymentMethodService.updatePaymentMethod(paymentMethod);
        return ResponseEntity.ok(updatedPaymentMethod);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
        paymentMethodService.deletePaymentMethod(id);
        return ResponseEntity.noContent().build();
    }
}
