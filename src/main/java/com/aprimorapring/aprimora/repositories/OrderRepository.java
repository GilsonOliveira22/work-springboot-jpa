package com.aprimorapring.aprimora.repositories;

import com.aprimorapring.aprimora.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
