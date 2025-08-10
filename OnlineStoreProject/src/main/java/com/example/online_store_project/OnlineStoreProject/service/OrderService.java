package com.example.online_store_project.OnlineStoreProject.service;

import com.example.online_store_project.OnlineStoreProject.dto.request.OrderRequestDTO;
import com.example.online_store_project.OnlineStoreProject.dto.response.OrderLineResponseDTO;
import com.example.online_store_project.OnlineStoreProject.dto.response.OrderResponseDTO;
import com.example.online_store_project.OnlineStoreProject.entity.Order;
import com.example.online_store_project.OnlineStoreProject.entity.OrderLine;
import com.example.online_store_project.OnlineStoreProject.entity.Product;
import com.example.online_store_project.OnlineStoreProject.entity.User;
import com.example.online_store_project.OnlineStoreProject.enums.OrderStatus;
import com.example.online_store_project.OnlineStoreProject.repository.OrderRepository;
import com.example.online_store_project.OnlineStoreProject.repository.ProductRepository;
import com.example.online_store_project.OnlineStoreProject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO dto) {
        User client = userRepository.findById(dto.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));

        Order order = new Order();
        order.setUserName(dto.getUserName());
        order.setDeliveryAddress(dto.getDeliveryAddress());
        order.setSubmissionDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.NEW);
        order.setClient(client);

        double totalCost = 0.0;

        for (var lineDto : dto.getOrderLines()) {
            Product product = productRepository.findById(lineDto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found"));

            OrderLine line = new OrderLine();
            line.setProduct(product);
            line.setQuantity(lineDto.getQuantity());
            line.setProductPrice(product.getPrice());
            line.setOrder(order);

            totalCost += product.getPrice() * lineDto.getQuantity();
            order.getOrderLine().add(line);
        }

        order.setTotalCost(totalCost);
        Order saved = orderRepository.save(order);
        return toDto(saved);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderResponseDTO getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id " + id));
    }

    @Transactional
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id))
            throw new EntityNotFoundException("Order not found with id " + id);
        orderRepository.deleteById(id);
    }

    private OrderResponseDTO toDto(Order order) {
        return OrderResponseDTO.builder()
                .id(order.getId())
                .userName(order.getUserName())
                .deliveryAddress(order.getDeliveryAddress())
                .submissionDate(order.getSubmissionDate())
                .orderStatus(order.getOrderStatus())
                .clientId(order.getClient().getId())
                .totalCost(order.getTotalCost())
                .orderLines(order.getOrderLine().stream().map(this::lineToDto).toList())
                .build();
    }

    private OrderLineResponseDTO lineToDto(OrderLine line) {
        return OrderLineResponseDTO.builder()
                .id(line.getId())
                .productId(line.getProduct().getId())
                .productName(line.getProduct().getProductType().name())
                .productPrice(line.getProductPrice())
                .quantity(line.getQuantity())
                .build();
    }

}