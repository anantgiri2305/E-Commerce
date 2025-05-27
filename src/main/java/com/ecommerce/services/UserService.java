package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    public void register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            // User already exists, skip saving or throw error
            return;
        }
        userRepository.save(user);
    }

    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }
}
