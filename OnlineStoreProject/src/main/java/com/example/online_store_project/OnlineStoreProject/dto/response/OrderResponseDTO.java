package com.example.online_store_project.OnlineStoreProject.dto.response;

import com.example.online_store_project.OnlineStoreProject.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO {
    private Long id;
    private String userName;
    private double totalCost;
    private String deliveryAddress;
    private LocalDateTime submissionDate;
    private OrderStatus orderStatus;
    private List<OrderLineResponseDTO> orderLines;
    private Long clientId;
}

