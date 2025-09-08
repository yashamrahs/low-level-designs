package strategy.paymentstrategies;

import strategy.PaymentStrategy;

public class UPIPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Procession UPI payment of $" + amount);
    }
}
