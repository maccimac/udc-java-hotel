package service;

import java.text.ParseException;
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


    static  ReservationService service = ReservationService.reservationServiceInstance;
    public static void populateRooms(){

        ArrayList<IRoom> rooms = new ArrayList<IRoom>(
                List.of(
                        new FreeRoom("1a", RoomType.SINGLE),
                        new Room("1b", RoomType.DOUBLE, 100.00),
                        new Room("1c", RoomType.SINGLE, 60.00),
                        new Room("2a", RoomType.SINGLE, 70.00),
                        new Room("2b", RoomType.DOUBLE, 95.00),
                        new Room("2c", RoomType.DOUBLE, 120.00)
                )
        );

        for(IRoom r: rooms){
            System.out.println(r);
            service.addRoom(r);
        }

    }

    public static void main(String[] args) throws Exception {
//        CustomerServiceTest customerServiceTest = CustomerServiceTest.customerServiceTestInstance;
//        CustomerServiceTest.customerServiceTestInstance.populateCustomers();

        CustomerServiceTest.populateCustomers();
        CustomerService customerService = CustomerService.customerServiceInstance;



        DateUtils dateUtils = new DateUtils();
//
//        ArrayList<IRoom> rooms = new ArrayList<IRoom>(
//            List.of(
//                new FreeRoom("1a", RoomType.SINGLE),
//                new Room("1b", RoomType.DOUBLE, 100.00),
//                new Room("1c", RoomType.SINGLE, 60.00),
//                new Room("2a", RoomType.SINGLE, 70.00),
//                new Room("2b", RoomType.DOUBLE, 95.00),
//                new Room("2c", RoomType.DOUBLE, 120.00)
//            )
//        );
//
//        for(IRoom r: rooms){
//            System.out.println(r);
//            service.addRoom(r);
//        }

        populateRooms();
        service.printAllRooms();

        System.out.println("\n -------- \n");

        Reservation r = service.reserveARoom(
                customerService.getCustomer("jkr@email.com"),
                service.getARoom("p_1b_2"),
                dateUtils.createDate("2024-01-01"),
                dateUtils.createDate("2024-01-05")
        );

        System.out.println(r.toString());

        Reservation r2 = service.reserveARoom(
                customerService.getCustomer("jkr@email.com"),
                service.getARoom("p_1b_2"),
//                service.getARoom("f_1a_1"),
                dateUtils.createDate("2024-01-01"),
                dateUtils.createDate("2024-01-05")
        );



    }

}
