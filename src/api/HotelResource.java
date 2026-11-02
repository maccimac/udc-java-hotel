package api;

import model.Customer;
import model.FreeRoom;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 * Next you'll need to create the HotelResource class.
 * The HotelResource should have little to no behavior contained inside the class and should make use of the Service classes to implement its methods.
 * The HotelResource will have the following methods:
 *
 * - [/] getCustomer(String email)
 * - [/] createACustomer(String email, String firstName, String lastName) or equivalent parameters in the same style
 * - [] getRoom(String roomNumber)
 * - [] bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate)
 * - [] getCustomersReservations(String customerEmail)
 * - [] findARoom(Date checkIn, Date checkOut)
 */



public class HotelResource {

    public static final HotelResource hotelResourceInstance = new HotelResource();
    static CustomerService customerService = CustomerService.customerServiceInstance;
    static ReservationService reservationService = ReservationService.reservationServiceInstance;

    // CUSTOMER FLOW
    public static Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }
    public static Customer createCustomerFlow(){

        Customer customer = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();

        try{
            customer = createACustomer(name, lastName, email);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return getCustomer(email);
    }
    public static Customer createACustomer( String firstName, String lastName, String email) throws Exception{
        return customerService.addCustomer(firstName, lastName, email);
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

    // RESERVATION FLOW
    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return null;
    }





    // DISPLAY
    public static void printAllCustomers (){
        System.out.println(":::: ALL CUSTOMERS ::::");
        Collection<Customer> allCustomers = CustomerService.getAllCustomers();
        allCustomers.forEach(customer -> {
            System.out.println(customer.toString());
        });
        System.out.println(":::: /end of list/ ::::");
    }

    public static void printAllRooms(){
        System.out.println(":::: ALL ROOMS ::::");
        ReservationService.reservationServiceInstance.printAllRooms();
        System.out.println(":::: /end of list/ ::::");
    }

}
