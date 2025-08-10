package com.example.online_store_project.OnlineStoreProject.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineRequestDTO {
    @NotNull(message = "Product id shouldn't be null")
    private Long id;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
}
