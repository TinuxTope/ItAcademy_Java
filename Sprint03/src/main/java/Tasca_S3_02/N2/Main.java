package Tasca_S3_02.N2;

import Tasca_S3_02.N2.Payment.*;
import Tasca_S3_02.N2.Store.ShoeStore;

public class Main {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PaymentGateway();
        ShoeStore shoeStore = new ShoeStore(paymentGateway);


        PaymentMethod creditCardPayment = new CreditCardPayment("1234-5678-9876-1234", "Tina Pena", 100.0);
        PaymentMethod paypalPayment = new PaypalPayment("tinux.tope@itAcademy.com", 200.0);
        PaymentMethod bankDebitPayment = new BankDebitPayment("678912345", 150.0);

        shoeStore.checkout(creditCardPayment);
        shoeStore.checkout(paypalPayment);
        shoeStore.checkout(bankDebitPayment);
    }

}
