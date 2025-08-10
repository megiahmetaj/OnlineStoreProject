package com.example.online_store_project.OnlineStoreProject.controller;

import com.example.online_store_project.OnlineStoreProject.dto.response.OrderLineResponseDTO;
import com.example.online_store_project.OnlineStoreProject.entity.Order;
import com.example.online_store_project.OnlineStoreProject.repository.OrderLineRepository;
import com.example.online_store_project.OnlineStoreProject.service.OrderLineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-lines")
public class OrderLineController {
    private final OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping
    public List<OrderLineResponseDTO> getAllOrdesLines(){
        return orderLineService.getAllOrderLines();
    }
    @GetMapping("/{id}")
    public OrderLineResponseDTO getOrderLineById(@PathVariable Long id){
        return orderLineService.getOrderLineById(id);
    }
}
