package api;

import static api.HotelResource.bookARoom;
import static api.HotelResource.reservationService;

import java.util.Collection;
import java.util.Date;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.CustomerServiceTest;
import service.ReservationService;
import service.ReservationServiceTest;
import utils.DateUtils;


public class HotelResourceTest {

    public static void main(String[] args) throws Exception {
        HotelResource resource = HotelResource.hotelResourceInstance;
//        ReservationService reservationService = ReservationService.reservationServiceInstance;

        DateUtils dateUtils = new DateUtils();

        CustomerServiceTest.populateCustomers();
        ReservationServiceTest.populateRooms();

        HotelResource.createACustomer("Julia", "Macaranas", "julia@email.com");

        HotelResource.printAllCustomers();

        Customer josh = resource.getCustomer("jkr@email.com");
        System.out.println(
            josh.toString()
        );

        IRoom selectedRoom = reservationService.getARoom("p_1b_2");
        IRoom selectedRoom2 = resource.getRoom(selectedRoom.roomId());
//        System.out.println(selectedRoom.toString());

        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + 24L * 60 * 60 * 1000);
        Date oct23 = dateUtils.createDate("2027-10-23");

        System.out.println(oct23);


        Reservation newReservation = resource.bookARoom(
                "jkr@email.com",
                selectedRoom2,
                today,
                oct23
        );

//        System.out.println(newReservation.toString());

        IRoom anotherSelectedRoom = reservationService.getARoom("p_2c_2");
        Reservation anotherReservation = resource.bookARoom(
                "jkr@email.com",
                anotherSelectedRoom,
                today,
                tomorrow
        );

        resource.bookARoom(
                "julia@email.com",
                anotherSelectedRoom,
                oct23,
                dateUtils.createDate("2027-10-25")
        );

        reservationService.printAllReservation();

        System.out.println("\n\n::: RESERVATIONS FOR jkr@email.com :::");
        Collection reservationsOfJkr= HotelResource.getCustomersReservations("jkr@email.com");
//        System.out.println(reservationsOfJkr);
        reservationsOfJkr.forEach(
                r -> {
                    System.out.println(r.toString());
                }
        );
        System.out.println("::: /end of RESERVATIONS LIST :::");

    }
}
