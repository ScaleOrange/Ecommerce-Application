package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	Optional<Cart> findByUserId(Integer userId);
}
