package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import model.Customer;


/**
 - [ ] `public void addCustomer(String email, String firstName, String lastName)`
 - [ ] `public Customer getCustomer(String customerEmail)`
 - [ ] `public Collection<Customer> getAllCustomers()`
 - [ ] Provide a static reference
 */

public class CustomerService {
    public static CustomerService customerServiceInstance = new CustomerService();

    private static final Set<Customer> customersSet = new HashSet<>();
    private static final Map<String, Customer> customersMap = new HashMap<>();


    public CustomerService(){

    }

    public static Customer addCustomer(String firstName, String lastName, String email) throws Exception {
        if( getCustomer(email) != null){
            throw new Exception("Customer with this email already exists");
        }
        Customer customer = new Customer(
                firstName, lastName, email);
        customersSet.add(customer);
        customersMap.put(email, customer);
        return customer;
    }

    public static Customer getCustomer(String customerEmail){
        return customersMap.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers(){
        // returns customers without the keys
        return customersMap.values();
    }
}
