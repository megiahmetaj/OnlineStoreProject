package com.example.online_store_project.OnlineStoreProject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToOne
//    private Category parent;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

//    @OneToMany(mappedBy = "parentCategory")
//    private List<Category> childrenCategories;
}

