package com.aprimorapring.aprimora.repositories;

import com.aprimorapring.aprimora.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
