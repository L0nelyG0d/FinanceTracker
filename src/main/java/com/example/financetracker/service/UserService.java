package com.example.financetracker.service;

import com.example.financetracker.model.User;
import com.example.financetracker.repository.UserRepository;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.Optional;


import com.example.financetracker.model.User;
import com.example.financetracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
