package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.Customer;


public class CustomerService {
    private static Set<Customer> customersSet = new HashSet<>();
    private static Map<String, Customer> customersMap = new HashMap<>();

    public static void addCustomer(String email, String firstName, String lastName) throws Exception {
        if( getCustomer(email) != null){
            throw new Exception("Customer with this email already exists");
        }
        Customer customer = new Customer(
                firstName, lastName, email);
        customersSet.add(customer);
        customersMap.put(email, customer);
    }

    public static Customer getCustomer(String customerEmail){
        return customersMap.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers(){
        // returns customers without the keys
        return customersMap.values();
    }
}
