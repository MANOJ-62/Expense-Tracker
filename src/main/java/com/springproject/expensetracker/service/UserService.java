package com.springproject.expensetracker.service;

import com.springproject.expensetracker.dto.UserWithPaymentMethodsDTO;
import com.springproject.expensetracker.model.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username, String password);
    User updateUser(User user);
    boolean changePassword(Long userId, String oldPassword, String newPassword);
    boolean verifyUser(String username, String email);
	UserWithPaymentMethodsDTO getUserWithPaymentMethods(Long userId);
}
