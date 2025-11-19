package app;

import models.Order;
import models.Customer;
import models.Employee;
import models.Product;
import models.Payment;



 import java.time.LocalTime;

    public class Main {
        public static void main(String[] args) {
            // Init shop
            CafeShop shop = new CafeShop();

            // Products
            Product latte = new Product("Latte ", 35.0, " coffee ", true);
            Product croissant = new Product(" Croissant ", 18.0, " food ", true);
            Product espresso = new Product("Espresso ", 25.0,   "  coffee ", false); // currently unavailable

            shop.addProductToMenu(latte);
            System.out.println("-------------------------------------------------------");
            shop.addProductToMenu(croissant);
            shop.addProductToMenu(espresso);

            shop.printMenu();

            // Employees
            Employee alice = new Employee("Alice ", "barista ");
            alice.addSchedule("Monday ", LocalTime.of(9,0), LocalTime.of(17,0));
            Employee bob = new Employee("Bob ", "manager ");
            shop.hireEmployee(alice);
            shop.hireEmployee(bob);
            System.out.println("-------------------------------------------------------");
            System.out.println(alice);

            // Customer
            Customer Andreea = new Customer("Andreea ", "+37360844995");

            //john.addPoints(120); // VIP now
            System.out.println("-------------------------------------------------------");
            System.out.println(Andreea);

            // Create an order
            Order order = new Order();
            order.addProduct(latte);
            order.addProduct(croissant);
            order.addProduct(espresso); // will print not available
            System.out.println("-------------------------------------------------------");
            System.out.println(order);
            System.out.println("-------------------------------------------------------");
            order.changeStatus(Order.Status.PREPARING);
            System.out.println("-------------------------------------------------------");
            System.out.println(order);
            System.out.println("-------------------------------------------------------");

            // Pay
            Payment payment = new Payment(order.getTotalAmount(), " card ");
            boolean success = shop.checkout(order, payment);
            System.out.println("-------------------------------------------------------");
            System.out.println("Checkout success: " + success);

           // System.out.println(order);
        }
    }
