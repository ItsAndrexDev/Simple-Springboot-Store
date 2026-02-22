package com.example.demo.ordering;

import com.example.demo.ordering.paymentServices.CryptoPaymentService;
import com.example.demo.ordering.paymentServices.PaymentService;
import com.example.demo.ordering.paymentServices.PaypalPaymentService;
import com.example.demo.ordering.paymentServices.StripePaymentService;

public class OrderService {


    public Boolean placeOrder(int productId, int quantity, String paymentMethod, int amount) throws PaymentError {
        PaymentService paymentService = switch (paymentMethod) {
            case "Stripe" -> new StripePaymentService();
            case "PayPal" -> new PaypalPaymentService();
            case "Crypto" -> new CryptoPaymentService();
            default -> throw new PaymentError("Unsupported payment method: " + paymentMethod);
        };

        paymentService.processPayment(amount);

        System.out.println("Order placed successfully!");
        System.out.println("Product ID: " + productId);
        System.out.println("Quantity: " + quantity);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Amount: " + amount);
        return true;
    }
}
