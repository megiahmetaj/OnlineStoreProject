package com.example.online_store_project.OnlineStoreProject.service;

import com.example.online_store_project.OnlineStoreProject.dto.request.UserRequestDTO;
import com.example.online_store_project.OnlineStoreProject.dto.response.UserResponseDTO;
import com.example.online_store_project.OnlineStoreProject.entity.User;
import com.example.online_store_project.OnlineStoreProject.enums.Role;
import com.example.online_store_project.OnlineStoreProject.mapper.UserMapper;
import com.example.online_store_project.OnlineStoreProject.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO registerUser(@Valid UserRequestDTO userRequestDTO) {
        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }

        User user = UserMapper.toEntity(userRequestDTO);

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

        // Force role to USER for registration
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);

        return UserMapper.toDTO(savedUser);
    }

    public Optional<UserResponseDTO> findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper::toDTO);
    }

    public Optional<UserResponseDTO> getUserById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDTO);
    }

    // Update user info (except role and password here for simplicity)
    public UserResponseDTO updateUser(Long id, UserRequestDTO updatedData) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (updatedData.getAvatar() != null) user.setAvatar(updatedData.getAvatar());
        if (updatedData.getAddress() != null) {
            user.setAddress(UserMapper.toEntity(updatedData).getAddress());
        }
        // You can add password change with hashing, role update with proper authorization here

        return UserMapper.toDTO(userRepository.save(user));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }
        userRepository.deleteById(userId);
    }

    public User changeUserRole(Long userId, Role newRole) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        user.setRole(newRole);
        return userRepository.save(user);
    }
}
