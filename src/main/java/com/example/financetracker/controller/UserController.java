package com.example.financetracker.controller;

import com.example.financetracker.model.User;
import com.example.financetracker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createadUser = userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(createadUser);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {

        boolean isit = userService.deleteUser(id);

        return isit ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
