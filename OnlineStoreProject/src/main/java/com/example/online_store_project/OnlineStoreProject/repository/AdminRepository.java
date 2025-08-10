package com.example.online_store_project.OnlineStoreProject.repository;

import com.example.online_store_project.OnlineStoreProject.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
