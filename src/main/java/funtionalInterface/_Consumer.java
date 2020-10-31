package funtionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Customer customer = new Customer("Maria", "99999");
        greetCustomer(customer);
        greetCustomerConsumer.accept(customer);
        greetCustomerV2(customer, true);
        greetCustomerConsumerV2.accept(customer, false);

    }
      static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 =
            (customer, showPhoneNumber) -> System.out.println("Hello " + customer.customerName +
                    ", thanks for registering your phone number" +
                    (showPhoneNumber ? (customer.customerPhoneNumber) : "*****"));

    static Consumer<Customer> greetCustomerConsumer =
            customer -> System.out.println("Hello " + customer.customerName +
                    ", thanks for registering your phone number" +
                    customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering your phone number" +
                customer.customerPhoneNumber);
    }

    static void greetCustomerV2 (Customer customer, Boolean showPhoneNumber){
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering your phone number" +
                (showPhoneNumber ? (customer.customerPhoneNumber) : "*****"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

    }
}
