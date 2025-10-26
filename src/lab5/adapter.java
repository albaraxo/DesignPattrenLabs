package lab5;

public class adapter {
}
 interface PaymentProcessor {
    void processPayment(double amount);
}
// Gateway 1
 class Madda {
    public void processPayment(double amount) {
        System.out.println("Processing payment via Mada: " + amount);
    }
}

// Gateway 2
 class ApplePay {
    public void authorizePayment(double amount) {
        System.out.println("Authorizing payment via ApplePay: " + amount);
    }
}

// Gateway 3
 class Tabby {
    public void makeTransaction(double amount) {
        System.out.println("Making transaction via Tabby: " + amount);
    }
}

 class UnifiedPaymentProcessor implements PaymentProcessor {

    private PaymentProcessor paymentProcessor; // composition

    // Constructor injection — allows us to plug in any adapter
    public UnifiedPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @Override
    public void processPayment(double amount) {
        paymentProcessor.processPayment(amount);  // delegate to adapter
    }
}

 class MaddaAdapter implements PaymentProcessor {
    private Madda gateway = new Madda();
    @Override
    public void processPayment(double amount) {
        gateway.processPayment(amount);
    }
}

 class ApplePayAdapter implements PaymentProcessor {
    private ApplePay gateway = new ApplePay();
    @Override
    public void processPayment(double amount) {
        gateway.authorizePayment(amount);
    }
}

 class TabbyAdapter implements PaymentProcessor {
    private Tabby gateway = new Tabby();
    @Override
    public void processPayment(double amount) {
        gateway.makeTransaction(amount);
    }
}
 class Main {
    public static void main(String[] args) {

        PaymentProcessor mada = new MaddaAdapter();
        PaymentProcessor applePay = new ApplePayAdapter();
        PaymentProcessor tabby = new TabbyAdapter();

        UnifiedPaymentProcessor madaProcessor = new UnifiedPaymentProcessor(mada);
        madaProcessor.processPayment(100.0);

        UnifiedPaymentProcessor appleProcessor = new UnifiedPaymentProcessor(applePay);
        appleProcessor.processPayment(150.0);

        UnifiedPaymentProcessor tamaraProcessor = new UnifiedPaymentProcessor(tabby);
        tamaraProcessor.processPayment(200.0);
    }
}


