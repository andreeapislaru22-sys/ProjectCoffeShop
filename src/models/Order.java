package models;

 import java.util.ArrayList;
import java.util.List;

    public class Order {
        private static int NEXT_ID = 1;

        private final int orderId;
        private List<Product> items;
        private double totalAmount;
        private Status status;

        public Order() {
            this.orderId = NEXT_ID++;
            this.items = new ArrayList<>();
            this.totalAmount = 0.0;
            this.status = Status.NEW;
        }

        public int getOrderId() {
            return orderId;
        }

        public List<Product> getItems() {
            return items;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public Status getStatus() {
            return status;
        }

        public void addProduct(Product p) {
            if(p == null) {
                System.out.println("Cannot add null product.");
                return;
            }
            if(!p.isAvailable()) {
                System.out.println("Product " + p.getName() + " is not available.");
                return;
            }
            items.add(p);
            calculateTotal();
        }

        public void removeProduct(Product p) {
            if(items.remove(p)) {
                calculateTotal();
            } else {
                System.out.println("Product not in order.");
            }
        }

        public void calculateTotal() {
            double sum = 0.0;
            for(Product p : items) {
                sum += p.getPrice();
            }
            this.totalAmount = Math.round(sum * 100.0) / 100.0;
        }

        /**
         * Change status with simple checks.
         */
        public void changeStatus(Status newStatus) {
            if(newStatus == null) {
                System.out.println("Invalid status.");
                return;
            }
            if(this.status == Status.COMPLETED || this.status == Status.CANCELLED) {
                System.out.println("Order already finished (COMPLETED/CANCELLED). Cannot change.");
                return;
            }
            // example rule: cannot go from NEW directly to COMPLETED
            if(this.status == Status.NEW && newStatus == Status.COMPLETED) {
                System.out.println("Cannot complete an order that hasn't been prepared.");
                return;
            }
            this.status = newStatus;
        }

        @Override
        public String toString() {
            return "Order#" + orderId + " [" + status + "] - Items: " + items.size() + " - Total: " + totalAmount + " MDL";
        }

        public enum Status {
            NEW, PREPARING, READY, COMPLETED, CANCELLED
        }
    }

