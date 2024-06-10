package Tasca_S3_02.N2.Payment;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolder;
    private double amount;

    public CreditCardPayment(String cardNumber, String cardHolder, double amount) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("Paying " + amount + " using Credit Card: " + cardNumber + " for " + cardHolder);
    }
}
