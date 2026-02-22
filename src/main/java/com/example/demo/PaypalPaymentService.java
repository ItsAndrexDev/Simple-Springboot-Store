package com.example.demo;

public class PaypalPaymentService implements PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing" + amount + " payment with PayPal...");
    }
}
