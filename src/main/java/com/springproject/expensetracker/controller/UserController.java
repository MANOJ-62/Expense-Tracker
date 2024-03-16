package com.springproject.expensetracker.controller;

import com.springproject.expensetracker.dto.UserWithPaymentMethodsDTO;
import com.springproject.expensetracker.model.User;
import com.springproject.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/{userId}/details")
    public ResponseEntity<UserWithPaymentMethodsDTO> getUserDetails(@PathVariable Long userId) {
        UserWithPaymentMethodsDTO userDTO = userService.getUserWithPaymentMethods(userId);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.loginUser(username, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestParam Long userId, @RequestParam String oldPassword, @RequestParam String newPassword) {
        boolean result = userService.changePassword(userId, oldPassword, newPassword);
        if (result) {
            return ResponseEntity.ok("Password changed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to change password");
        }
    }

    @GetMapping("/verify")
    public ResponseEntity<Boolean> verifyUser(@RequestParam String username, @RequestParam String email) {
        boolean exists = userService.verifyUser(username, email);
        return ResponseEntity.ok(exists);
    }
}
