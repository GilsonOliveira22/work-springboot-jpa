package com.aprimorapring.aprimora.repositories;

import com.aprimorapring.aprimora.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
