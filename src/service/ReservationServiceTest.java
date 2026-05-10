package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Customer;
import model.FreeRoom;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;
import utils.DateUtils;


public class ReservationServiceTest {

    public static void main(String[] args) {
        ReservationService service = new ReservationService();
        DateUtils dateUtils = new DateUtils();


        Customer josh = new Customer(
                "Josh", "Rizal", "jkr@email.com"
        );
        Customer kevin = new Customer(
                "Kevin", "Rizal", "kev@email.com"
        );
        Customer phil = new Customer(
                "Phil", "Rizal", "phil@email.com"
        );

        ArrayList<IRoom> rooms = new ArrayList<IRoom>(
            List.of(
                new FreeRoom("1a", RoomType.SINGLE),

                new Room("1b", RoomType.DOUBLE, 100.00)
            )
        );

        for(IRoom r: rooms){
            System.out.println(r);
            service.addRoom(r);
        }
//        service.printAllRooms();

        System.out.println("\n -------- \n");

        Reservation r =service.reserveARoom(
                josh,
                service.getARoom("p_1b_2"),
                dateUtils.createDate("2024-01-01"),
                dateUtils.createDate("2024-01-05")
        );

        System.out.println(r.toString());


    }

}
