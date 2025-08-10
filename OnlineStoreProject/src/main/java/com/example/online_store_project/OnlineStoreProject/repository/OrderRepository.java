package com.example.online_store_project.OnlineStoreProject.repository;

import com.example.online_store_project.OnlineStoreProject.entity.Order;
import com.example.online_store_project.OnlineStoreProject.entity.User;
import com.example.online_store_project.OnlineStoreProject.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClient(User client);
    List<Order> findByStatus(OrderStatus status);
}
