package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;


/**
 * Next you'll need to create the HotelResource class.
 * The HotelResource should have little to no behavior contained inside the class and should make use of the Service classes to implement its methods.
 * The HotelResource will have the following methods:
 */

public class HotelResource {

    public static final HotelResource hotelResourceInstance = new HotelResource();

    static CustomerService customerService = CustomerService.customerServiceInstance;
    static ReservationService reservationService = ReservationService.reservationServiceInstance;

    public static Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public static void createACustomer( String firstName, String lastName, String email) throws Exception{
        customerService.addCustomer(firstName, lastName, email);
    }

    public static IRoom getRoom(String roomNumber) {
            return reservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {

        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.reserveARoom(
                customer,
                room,
                checkInDate,
                checkOutDate
        );

    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = getCustomer(customerEmail);
        return reservationService.getCustomersReservation(customer);
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return null;
    }

    /**
     * Optional
     */

    public static void printAllCustomers (){
        System.out.println(":::: ALL CUSTOMERS ::::");
        Collection<Customer> allCustomers = CustomerService.getAllCustomers();
        allCustomers.forEach(customer -> {
            System.out.println(customer.toString());
        });
        System.out.println(":::: /end of list/ ::::");
    }
}
