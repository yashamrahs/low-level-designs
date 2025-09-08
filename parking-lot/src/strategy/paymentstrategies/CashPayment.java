package strategy.paymentstrategies;

import strategy.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Procession cash payment of $" + amount);
    }
}
