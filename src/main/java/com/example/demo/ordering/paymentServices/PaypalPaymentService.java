package com.example.demo.ordering.paymentServices;

import com.example.demo.ordering.PaymentError;

public class PaypalPaymentService implements PaymentService{

    @Override
    public boolean processPayment(double amount) throws PaymentError {
        System.out.println("Processing" + amount + " payment with PayPal...");
        return true;
    }
}
