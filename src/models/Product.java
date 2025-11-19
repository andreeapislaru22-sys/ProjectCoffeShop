package models;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private String category; // ex: "coffee", "tea", "food"
    private boolean available;

    public Product(String name, double price, String category, boolean available) {
        this.name = name;
        setPrice(price);
        this.category = category;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name required");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        if(price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Apply discount in percent. If percent invalid => no change.
     */
    public void applyDiscount(double percent) {
        if(percent <= 0) {
            System.out.println("Discount must be positive. No discount applied.");
            return;
        }
        if(percent > 50) {
            System.out.println("Discount too big (>50%). Request denied.");
            return;
        }
        double factor = (100 - percent) / 100.0;
        setPrice(Math.round((price * factor) * 100.0) / 100.0);
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - " + price + " MDL " + (available ? "" : " [unavailable] ");
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Product)) return false;
        Product p = (Product) o;
        return Objects.equals(name, p.name) && Objects.equals(category, p.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}