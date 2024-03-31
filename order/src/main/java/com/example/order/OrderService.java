package com.example.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrderById(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}
