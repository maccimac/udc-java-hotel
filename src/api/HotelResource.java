package api;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;


/**
 * Next you'll need to create the HotelResource class. The HotelResource should have little to no behavior contained inside the class and should make use of the Service classes to implement its methods. The HotelResource will have the following methods:
 */

public class HotelResource {

    // Is this how to "Provide a static reference"?
    private static final HotelResource hotelResource = new HotelResource();

    public static HotelResource getHotelResource() {
        return null;
    }

    private HotelResource() {
    }

    public static Customer getCustomer(String email) {
        return null;
    }

    public static void createACustomer(String email, String firstName, String lastName) throws Exception {
    }

    public static IRoom getRoom(String roomNumber) {
        return null;
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return null;
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail) {
        return null;
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return null;
    }
}
