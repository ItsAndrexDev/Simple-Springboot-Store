package com.example.demo.ordering.paymentServices;

import com.example.demo.ordering.PaymentError;

public interface PaymentService {
    boolean processPayment(double amount) throws PaymentError;
}
