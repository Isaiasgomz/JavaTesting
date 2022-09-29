package platzi.JavaTesting.Payments;

public interface PaymentGateway {

    PaymentResponse requestPayment (PaymentRequest paymentRequest);
}
