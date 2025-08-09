package com.example.online_store_project.OnlineStoreProject.entity;

import com.example.online_store_project.OnlineStoreProject.enums.MessageChannel;
import com.example.online_store_project.OnlineStoreProject.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String city;

    private Address address;

    private String avatar;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private MessageChannel messageChannel;
}
