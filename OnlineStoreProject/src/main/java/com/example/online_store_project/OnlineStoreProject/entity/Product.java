package com.example.online_store_project.OnlineStoreProject.entity;


import com.example.online_store_project.OnlineStoreProject.enums.ProductType;
import jakarta.persistence.*;
import com.example.online_store_project.OnlineStoreProject.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String thumbnail;
    private double price;

    @ManyToOne
    private Category category;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @ManyToOne
    private Admin admin;








}
