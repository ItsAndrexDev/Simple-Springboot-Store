package com.example.demo;

public class StripePaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        // Simulate payment processing logic
        System.out.println("Processing" + amount + " payment with Stripe...");
    }
}
