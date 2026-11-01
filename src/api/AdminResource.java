package api;

import model.Customer;
import service.CustomerService;


/**
 * - [ ] Provide a `static` reference
 * - [ ] `public Customer getCustomer(String email)`
 * - [ ] `public void addRoom(List<IRoom> rooms)`
 * - [ ] `public Collection<IRoom> getAllRooms()`
 * - [ ] `public Collection<Customer> getAllCustomers()`
 * - [ ] `public void displayAllReservations()`
 */


public class AdminResource {
    // Static reference
    public static final AdminResource adminResourceInstance = new AdminResource();

    static CustomerService customerService = new CustomerService();

    public static Customer getCustomer(String email){
       return customerService.getCustomer(email);
    }




}
