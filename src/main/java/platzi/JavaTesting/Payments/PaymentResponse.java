package platzi.JavaTesting.Payments;

public class PaymentResponse {

    enum PaymentStatus{
        OK, ERROR
    }

    PaymentStatus paymentStatus;

    public PaymentResponse(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
