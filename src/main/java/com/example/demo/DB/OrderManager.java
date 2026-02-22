package com.example.demo.DB;

import com.example.demo.DTO.OrderPlacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderManager {
    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
    public Optional<Order> getOrder(int id) {
        return orderRepository.findById(id);
    }
}
