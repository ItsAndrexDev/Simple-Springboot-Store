package com.example.demo;

import com.example.demo.DB.Order;
import com.example.demo.DTO.OrderPlacement;
import com.example.demo.ordering.OrderService;
import com.example.demo.ordering.PaymentError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @PostMapping("/order")
    public ResponseEntity<String> placeOrder(@ModelAttribute OrderPlacement order){
        System.out.println("Placing order in " + appName);
        OrderService orderService = new OrderService();
        try {
            orderService.placeOrder(order.getProductId(), order.getQuantity(), order.getPaymentMethod(), order.getAmount());
        } catch (PaymentError e) {
            if(e.getMessage().startsWith("402")) {
                return ResponseEntity.status(402).body(e.getMessage());
            }
            return ResponseEntity.badRequest().body("Incorrect payment method: " + order.getPaymentMethod());
        }

        Order DBOrder = new Order();
        DBOrder.setProductId(order.getProductId());
        DBOrder.setQuantity(order.getQuantity());
        DBOrder.setPaymentMethod(order.getPaymentMethod());
        DBOrder.setPrice(order.getAmount());

        Main.orderManager.saveOrder(DBOrder);

        return ResponseEntity.ok("Order placed successfully!");
    }
}
