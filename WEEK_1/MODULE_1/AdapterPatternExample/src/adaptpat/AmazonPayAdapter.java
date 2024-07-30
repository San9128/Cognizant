package adaptpat;
public class AmazonPayAdapter implements PaymentProcessor {
    private AmazonPayGateway amazonPayGateway;
    public AmazonPayAdapter(AmazonPayGateway amazonPayGateway) {
        this.amazonPayGateway = amazonPayGateway;
    }
    @Override
    public void processPayment(double amount) {
        amazonPayGateway.pay(amount);
    }
}
