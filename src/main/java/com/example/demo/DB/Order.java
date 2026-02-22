package com.example.demo.DB;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // if AUTO_INCREMENT
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "price")
    private int price;


    // getters and setters
    public int getId() { return id; }


    public int getProductId() { return productId; }
    public void setProductId(int prodId) { this.productId = prodId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
