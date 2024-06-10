package Tasca_S3_02.N2.Payment;

public class PaypalPayment implements PaymentMethod{
    private String email;
    private double amount;

    public PaypalPayment(String email, double amount) {
        this.email = email;
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("Paying " + amount + " using Paypal: " + email);
    }
}
