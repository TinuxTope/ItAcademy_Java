package Tasca_S3_02.N2.Store;

import Tasca_S3_02.N2.Payment.PaymentGateway;
import Tasca_S3_02.N2.Payment.PaymentMethod;
import Tasca_S3_02.N2.PaymentProcessingException.PaymentProcessingException;

public class ShoeStore {
    private PaymentGateway paymentGateway;

    public ShoeStore(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout(PaymentMethod paymentMethod) {
        System.out.println("Initiating checkout process...");
        try {
            paymentGateway.processPayment(paymentMethod);
            System.out.println("Checkout process completed.");
        } catch (PaymentProcessingException e) {
            System.err.println("Error during payment processing: " + e.getMessage());
        }
    }
}
