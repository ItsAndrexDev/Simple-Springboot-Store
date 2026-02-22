package com.example.demo.ordering.paymentServices;

import com.example.demo.ordering.PaymentError;

public class CryptoPaymentService implements PaymentService{
    @Override
    public boolean processPayment(double amount) throws PaymentError {
        System.out.println("Processing" + amount + " payment with Cryptocurrency...");
        return true;
    }
}
