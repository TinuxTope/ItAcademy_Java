package Tasca_S3_02.N2.Payment;

import Tasca_S3_02.N2.PaymentProcessingException.PaymentProcessingException;

public class PaymentGateway {
    public void processPayment(PaymentMethod paymentMethod) throws PaymentProcessingException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new PaymentProcessingException("Payment processing was interrupted", e);
        }

        paymentMethod.pay();
    }
}
