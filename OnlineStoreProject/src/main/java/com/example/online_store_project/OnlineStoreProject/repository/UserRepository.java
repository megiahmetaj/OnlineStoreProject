package com.example.online_store_project.OnlineStoreProject.repository;

import com.example.online_store_project.OnlineStoreProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String email);
}
