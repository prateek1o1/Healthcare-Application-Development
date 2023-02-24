package com.example.healthcare.service;

import com.example.healthcare.model.User;
import com.example.healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String password) {
        User user = userRepository.findById(email).orElse(null);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    public void saveLogin(User user) {
        userRepository.save(user);
    }

    public Iterable <User> getAllUsers() {
        return userRepository.findAll();
    }
}
