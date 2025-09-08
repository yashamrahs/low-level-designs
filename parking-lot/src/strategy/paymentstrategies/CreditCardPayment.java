package strategy.paymentstrategies;

import strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Procession CC payment of $" + amount);
    }
}
