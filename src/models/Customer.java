package models;

public class Customer {
    private String name;
    private String phoneNumber;
    private int loyaltyPoints;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.loyaltyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name required");
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addPoints(int points) {
        if(points <= 0) return;
        loyaltyPoints += points;
    }

    public void redeemPoints(int points) {
        if(points <= 0) return;
        if(points > loyaltyPoints) {
            System.out.println("Not enough points to redeem.");
            return;
        }
        loyaltyPoints -= points;
    }

    /**
     * VIP if points > 100
     */
    public boolean isVIP() {
        return loyaltyPoints > 100;
    }

    @Override
    public String toString() {
        return name + " (" + phoneNumber + ") - Points: " + loyaltyPoints + (isVIP() ? " [VIP]" : "");
    }
}
