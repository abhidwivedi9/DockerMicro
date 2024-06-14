package com.my3rdservice.orderservice.orderservice.service;

import com.my3rdservice.orderservice.orderservice.Repository.OrderRepository;

import com.my3rdservice.orderservice.orderservice.model.Orders;
import com.my3rdservice.orderservice.orderservice.model.Product;
import com.my3rdservice.orderservice.orderservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductServiceClient productServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Orders createOrder(Orders order) {
        // Validate user and product
        User user = userServiceClient.getUserById(order.getUserId());
        Product product = productServiceClient.getProductById(order.getProductId());

        // Calculate total price
        order.setTotalPrice(product.getPrice() * order.getQuantity());

        // Save order
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }}
