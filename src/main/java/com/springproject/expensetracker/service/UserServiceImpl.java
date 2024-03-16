package com.springproject.expensetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springproject.expensetracker.dto.PaymentMethodDTO;
import com.springproject.expensetracker.dto.UserWithPaymentMethodsDTO;
import com.springproject.expensetracker.model.PaymentMethod;
import com.springproject.expensetracker.model.User;
import com.springproject.expensetracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserWithPaymentMethodsDTO getUserWithPaymentMethods(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        logger.info("Fetched user: {}", user);  // Log user details for debugging

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


    @Override
    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean changePassword(Long userId, String oldPassword, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new RuntimeException("Old password does not match");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean verifyUser(String username, String email) {
        return userRepository.existsByUsernameAndEmail(username, email);
    }
}
