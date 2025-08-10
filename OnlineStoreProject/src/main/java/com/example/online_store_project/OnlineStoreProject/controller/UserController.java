package com.example.online_store_project.OnlineStoreProject.controller;

import com.example.online_store_project.OnlineStoreProject.dto.request.UserRequestDTO;
import com.example.online_store_project.OnlineStoreProject.dto.response.UserResponseDTO;
import com.example.online_store_project.OnlineStoreProject.entity.User;
import com.example.online_store_project.OnlineStoreProject.enums.Role;
import com.example.online_store_project.OnlineStoreProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        try {
            UserResponseDTO createdUser = userService.registerUser(userRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
    }



    // Update user info
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,
                                        @Valid @RequestBody UserRequestDTO userRequestDTO) {
        try {
            UserResponseDTO updatedUser = userService.updateUser(id, userRequestDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/role")
    public ResponseEntity<User> changeUserRole(@PathVariable Long id, @RequestParam Role role) {
        return ResponseEntity.ok(userService.changeUserRole(id, role));
    }


}
