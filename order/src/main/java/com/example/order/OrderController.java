package com.example.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final RestTemplate restTemplate;

    @PostMapping("/save")
    public Order saveOrder(Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/findAll")
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/find/{orderId}")
    public Order findOrderById(String orderId) {
        return orderService.findOrderById(orderId);
    }

    @GetMapping("/user/{username}")
    public User findOrdersByUser(@PathVariable("username") String username) {
        return restTemplate.getForObject("http://authentication/auth/user/" + username, User.class);
    }

}
