package com.aprimorapring.aprimora.repositories;

import com.aprimorapring.aprimora.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
