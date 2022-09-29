package platzi.JavaTesting.Payments;

public class PaymentProcessor {

    private  PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(int amount){
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        if (response.getPaymentStatus() == PaymentResponse.PaymentStatus.OK){
            return true;
        }else{
            return false;
        }
    }
}
