package com.example.online_store_project.OnlineStoreProject.service;

import com.example.online_store_project.OnlineStoreProject.dto.response.OrderLineResponseDTO;
import com.example.online_store_project.OnlineStoreProject.entity.OrderLine;
import com.example.online_store_project.OnlineStoreProject.repository.OrderLineRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public List<OrderLineResponseDTO> getAllOrderLines() {
        return orderLineRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public OrderLineResponseDTO getOrderLineById(Long id) {
        OrderLine orderLine = orderLineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order line not found"));
        return mapToResponseDTO(orderLine);
    }

    private OrderLineResponseDTO mapToResponseDTO(OrderLine line) {
        return OrderLineResponseDTO.builder()
                .id(line.getId())
                .productId(line.getProduct().getId())
                .productName(line.getProduct().getProductType().name())
                .productPrice(line.getProductPrice())
                .quantity(line.getQuantity())
                .build();
    }
}
