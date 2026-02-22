package com.example.demo;

import com.example.demo.DTO.OrderPlacement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @PostMapping("/order")
    public ResponseEntity<String> placeOrder(@ModelAttribute OrderPlacement order){
        System.out.println("Placing order in " + appName);
        OrderService orderService = new OrderService();
        try {
            orderService.placeOrder(order.getOrderId(), order.getQuantity(), order.getPaymentMethod(), order.getAmount());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Incorrect payment method: " + order.getPaymentMethod());
        }
        return ResponseEntity.ok("Order placed successfully!");
    }
}
