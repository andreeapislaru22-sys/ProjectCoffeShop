package models;

public class Payment {
    private double amount;
    private String method; // "cash", "card", "mobile"

    public Payment(double amount, String method) {
        this.amount = amount;
        this.method = method;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    /**
     * Basic validation: amount > 0 and method known.
     */
    public boolean validatePayment() {
        if(amount <= 0) {
            System.out.println("Invalid payment amount: " + amount);
            return false;
        }
        if(method == null) {
            System.out.println("Payment method missing.");
            return false;
        }
        String m = method.toLowerCase();
        if(m.equals("cash") || m.equals("card") || m.equals("mobile")) {
            return true;
        } else {
            System.out.println("Unsupported payment method: " + method);
            return false;
        }
    }

    @Override
    public String toString() {
        return method + " - " + amount + " MDL";
    }
}