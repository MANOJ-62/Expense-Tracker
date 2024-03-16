package com.springproject.expensetracker.controller;

import com.springproject.expensetracker.dto.PaymentMethodDTO;
import com.springproject.expensetracker.dto.UserWithPaymentMethodsDTO;
import com.springproject.expensetracker.model.PaymentMethod;
import com.springproject.expensetracker.model.User;
import com.springproject.expensetracker.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserWithPaymentMethodsDTO> getUserWithPaymentMethods(@PathVariable Long userId) {
        User user = paymentMethodService.getUserWithPaymentMethods(userId);
        if (user != null) {
            UserWithPaymentMethodsDTO userDTO = convertToDTO(user);
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private UserWithPaymentMethodsDTO convertToDTO(User user) {
        UserWithPaymentMethodsDTO userDTO = new UserWithPaymentMethodsDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setMonthlyIncome(user.getMonthlyIncome());
        userDTO.setCurrentBankBalance(user.getCurrentBankBalance());
        userDTO.setCurrentCashBalance(user.getCurrentCashBalance());
        userDTO.setCurrentCreditCardBalance(user.getCurrentCreditCardBalance());
        // Map payment methods to DTOs
        List<PaymentMethodDTO> paymentMethodDTOs = new ArrayList<>();
        for (PaymentMethod paymentMethod : user.getPaymentMethods()) {
            PaymentMethodDTO paymentMethodDTO = new PaymentMethodDTO();
            paymentMethodDTO.setPaymentMethodId(paymentMethod.getId());
            paymentMethodDTO.setPaymentType(paymentMethod.getPaymentType());
            paymentMethodDTO.setName(paymentMethod.getName());
            paymentMethodDTO.setBalance(paymentMethod.getBalance());
            paymentMethodDTOs.add(paymentMethodDTO);
        }
        userDTO.setPaymentMethods(paymentMethodDTOs);
        return userDTO;
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
