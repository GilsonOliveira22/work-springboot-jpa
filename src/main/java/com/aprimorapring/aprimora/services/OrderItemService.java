package com.aprimorapring.aprimora.services;

import com.aprimorapring.aprimora.entities.OrderItem;
import com.aprimorapring.aprimora.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public List<OrderItem> findAll() {
        return repository.findAll();
    }

    public OrderItem findById(Long id) {
        Optional<OrderItem> obj = repository.findById(id);
        return obj.get();
    }
}
