package com.example.demo.ordering.paymentServices;

import com.example.demo.ordering.PaymentError;

public class StripePaymentService implements PaymentService {

    @Override
    public boolean processPayment(double amount) throws PaymentError {
        // Simulate payment processing logic
        System.out.println("Processing" + amount + " payment with Stripe...");
        throw new PaymentError("402: Stripe payment failed due to insufficient funds.");
    }
}
