package com.example.online_store_project.OnlineStoreProject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    @NotBlank
    private String name;

    @NotNull
    private Double price;

    private String description;

    @NotNull
    private Long categoryId;
}