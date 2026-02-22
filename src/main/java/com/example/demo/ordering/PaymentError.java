package com.example.demo.ordering;

public class PaymentError extends RuntimeException {
    public PaymentError(String message) {
        super(message);
    }
}
