package com.example.online_store_project.OnlineStoreProject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineResponseDTO {
    private Long id;
    private Long productId;
    private String productName;
    private double productPrice;
    private int quantity;

}
