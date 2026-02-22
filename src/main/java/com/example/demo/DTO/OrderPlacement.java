package com.example.demo.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OrderPlacement {

    @NotNull
    private Integer orderId;      // Use wrapper class, not primitive
    @NotNull
    private Integer quantity;

    @NotEmpty
    private String paymentMethod;

    @NotNull
    private Integer amount;

    // Getters and setters required for @ModelAttribute binding
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
}
