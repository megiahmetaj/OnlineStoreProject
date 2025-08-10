package com.example.online_store_project.OnlineStoreProject.repository;

import com.example.online_store_project.OnlineStoreProject.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
