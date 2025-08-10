package com.example.online_store_project.OnlineStoreProject.repository;

import com.example.online_store_project.OnlineStoreProject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByParentIsNull();
    List<Category> findByParentId(Long parentId);
    List<Category> findByNameContainingIgnoreCase(String name);

}
