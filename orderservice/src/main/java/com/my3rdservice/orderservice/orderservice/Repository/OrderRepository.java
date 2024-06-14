package com.my3rdservice.orderservice.orderservice.Repository;


import com.my3rdservice.orderservice.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
