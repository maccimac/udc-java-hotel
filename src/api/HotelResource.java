package api;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

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
