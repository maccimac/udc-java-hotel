package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.FreeRoom;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;


/**
 * - [/] Provide a `static` reference
 * - [/] `public Customer getCustomer(String email)`
 * (When will I need this?)
 * - [ ] `public void addRoom(List<IRoom> rooms)`
 * - [ ] `public Collection<IRoom> getAllRooms()`
 * - [ ] `public Collection<Customer> getAllCustomers()`
 * - [ ] `public void displayAllReservations()`
 */


public class AdminResource {
    // Static reference
    public static final AdminResource adminResourceInstance = new AdminResource();



//    static CustomerService customerService = new CustomerService();

    public static Customer getCustomer(String email){
       return CustomerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        for (IRoom room : rooms){
            ReservationService.reservationServiceInstance.addRoom(room);
        }
    }

    public static void addRoomsFlow(){
        System.out.println("Let's create rooms");
        List<IRoom> rooms = new ArrayList<>();
        boolean createMoreRoom = true;
        Scanner scanner = new Scanner(System.in);

         while(createMoreRoom == true){

           // INPUT ROOM PARAMS
            String isFreeYOrN = "_";
            while(!isFreeYOrN.equals("N") && !isFreeYOrN.equals("Y") ){
                System.out.println("Is the room free? Yes (Y) or No (N)? Enter Y or N");
                isFreeYOrN = scanner.nextLine().toUpperCase();
            }

            String singleOrDouble = "_";
            while(!singleOrDouble.equals("S") && !singleOrDouble.equals("D") ){
                System.out.println("Is the room single (S) or double (D)? Enter S or D");
                singleOrDouble = scanner.nextLine().toUpperCase();
            }

            double price = 0;
            if(isFreeYOrN.equals("N")) {
                while (price == 0) {
                    System.out.println("How much is the room?");
                    try{
                        price = Double.parseDouble(scanner.nextLine());
                    }catch(Exception e){
                        System.out.println("Invalid price, enter a number");
                    }
                }
            }

            boolean isRoomNumUnique = false;
            String roomNum ="";
            while(!isRoomNumUnique){
                System.out.println("What is the room number?");
                roomNum = scanner.nextLine();
                isRoomNumUnique = ReservationService.reservationServiceInstance.isRoomNumUnique(roomNum);
                for(IRoom r: rooms){
                    if(r.getRoomNumber().equals(roomNum)){
                        isRoomNumUnique = false;
                    }
                }
                if(!isRoomNumUnique){
                    System.out.println("Enter different room number. Room number not unique.");
                }
            }

            // CREATE THE ROOM
            RoomType roomType = RoomType.SINGLE;
            if(singleOrDouble.equals("D")){
                roomType = RoomType.DOUBLE;
            }

            IRoom newRoom;
            if(isFreeYOrN.equals("Y")){
                newRoom = new FreeRoom(roomNum, roomType);
            }else{
                newRoom = new Room(roomNum, roomType, price);
            }
            rooms.add(newRoom);
            System.out.println("New room created: " + newRoom.toString());


            // ASK TO CREATE AGAIN
             System.out.println("Enter `NEW` to create a new room");
             String createNewRoom = scanner.nextLine().toUpperCase();
             if(!createNewRoom.equals("NEW")){
                 createMoreRoom = false;
             }

        } // End of while

        System.out.println("These are the new rooms you created:");
        for (IRoom r: rooms){
            System.out.println(r.toString());
            ReservationService.reservationServiceInstance.addRoom(r);
        }

    }




}
