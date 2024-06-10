package Tasca_S3_02.N2.Payment;

public class BankDebitPayment implements PaymentMethod{
    private String bankAccount;
    private double amount;

    public BankDebitPayment(String bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("Paying " + amount + " using Bank Debit: " + bankAccount);
    }
}
