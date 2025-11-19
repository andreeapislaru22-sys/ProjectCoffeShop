package app;

import models.Employee;
import models.Product;
import models.Customer;
import models.Payment;
import models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CafeShop {
    private List<Product> menu;
    private List<Employee> employees;
    private List<Order> orders;

    public CafeShop() {
        menu = new ArrayList<>();
        employees = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addProductToMenu(Product p) {
        if(p == null) return;
        menu.add(p);
    }

    public void removeProductFromMenu(Product p) {
        menu.remove(p);
    }

    public void printMenu() {
        System.out.println("---- Menu ----");
        for(Product p : menu) {
            System.out.println(p);
        }
    }

    public void hireEmployee(Employee e) {
        if(e == null) return;
        employees.add(e);
    }

    public void fireEmployee(Employee e) {
        employees.remove(e);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Order registerOrder(Order order) {
        if(order == null) throw new IllegalArgumentException("Order cannot be null");
        orders.add(order);
        return order;
    }

    public Optional<Order> findOrderById(int id) {
        return orders.stream().filter(o -> o.getOrderId() == id).findFirst();
    }

    /**
     * Checkout: validate payment and mark order completed if ok.
     */
    public boolean checkout(Order order, Payment payment) {
        if(order == null || payment == null) return false;
        if(order.getItems().isEmpty()) {
            System.out.println("Order is empty.");
            return false;
        }
        if(Math.abs(payment.getAmount() - order.getTotalAmount()) > 0.01) {
            System.out.println("Payment amount doesn't match order total. Order total: " + order.getTotalAmount() + ", paid: " + payment.getAmount());
            return false;
        }
        if(!payment.validatePayment()) return false;

        order.changeStatus(Order.Status.COMPLETED);
        System.out.println("Order " + order.getOrderId() + " completed via " + payment.getMethod());
        return true;
    }
}