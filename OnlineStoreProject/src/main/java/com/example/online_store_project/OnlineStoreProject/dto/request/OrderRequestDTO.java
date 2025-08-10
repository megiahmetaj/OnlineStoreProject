package com.example.online_store_project.OnlineStoreProject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    @NotBlank(message = "Username shouldn't be blank")
    private String userName;

    @NotBlank(message = "Delivery address is required")
    private String deliveryAddress;

    @NotNull(message = "Order lines cannot be null")
    private List<OrderLineRequestDTO> orderLines;

    @NotNull(message = "Client ID is required")
    private Long userId;



}
