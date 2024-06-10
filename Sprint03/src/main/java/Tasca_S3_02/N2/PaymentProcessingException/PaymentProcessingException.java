package Tasca_S3_02.N2.PaymentProcessingException;

public class PaymentProcessingException extends Exception{
    public PaymentProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentProcessingException(String message) {
        super(message);
    }
}
