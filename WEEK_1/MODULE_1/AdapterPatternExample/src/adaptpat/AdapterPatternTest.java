package adaptpat;
public class AdapterPatternTest {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PaypalAdapter(new PaypalGateway());
        paypalProcessor.processPayment(405.0);
        PaymentProcessor amazonPayProcessor = new AmazonPayAdapter(new AmazonPayGateway());
        amazonPayProcessor.processPayment(198.0);
    }
}
