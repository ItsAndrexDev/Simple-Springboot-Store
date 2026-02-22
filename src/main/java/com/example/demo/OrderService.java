package com.example.demo;

public class OrderService {


    public Boolean placeOrder(int orderId, int quantity, String paymentMethod, int amount) throws IllegalArgumentException {
        PaymentService paymentService = switch (paymentMethod) {
            case "Stripe" -> new StripePaymentService();
            case "PayPal" -> new PaypalPaymentService();
            default -> throw new IllegalArgumentException("Unsupported payment method: " + paymentMethod);
        };

        paymentService.processPayment(amount);

        System.out.println("Order placed successfully!");
        System.out.println("Order ID: " + orderId);
        System.out.println("Quantity: " + quantity);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Amount: " + amount);
        return true;
    }
}
