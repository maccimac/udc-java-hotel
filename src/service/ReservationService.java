package service;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import model.Customer;
import model.IRoom;
import model.Reservation;


public class ReservationService {


    Queue<Reservation> reservations = new LinkedList<>();
    List<IRoom> rooms = new LinkedList<IRoom>();

    // This is the constructor right?
    public ReservationService(){
        // Set initial reservations?
    }
    public void addRoom(IRoom room){
        if(rooms.isEmpty()){
            rooms.add(room);
            rooms.getLast().setRoomIdNumber(0);
            return;
        };
        IRoom lastRoom = rooms.get(rooms.size() - 1);
        int lastRoomNum = lastRoom.getRoomIdNumber();
        rooms.add(room);

        room.setRoomIdNumber(lastRoomNum+1);

    }
    public IRoom getARoom(String roomId){

        IRoom selectedRoom = null;
        for(IRoom room: rooms){
            System.out.println("looking for " +  room.roomId());
            if( room.roomId().equals(roomId)){
                selectedRoom = room;
                break;
            }
        }
        return selectedRoom;
    };

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        reservations.add(reservation);
        return reservation;

    }


    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

        Collection<IRoom> matchingRooms = new HashSet<>();
        for(Reservation r: reservations){
            Boolean onOrAfterCheckin = r.getCheckInDate().equals(checkInDate) || r.getCheckInDate().after(checkInDate);
            Boolean onOrBeforeCheckout = r.getCheckOutDate().equals(checkOutDate) || r.getCheckOutDate().before(checkOutDate);

            if(onOrAfterCheckin && onOrBeforeCheckout){
                matchingRooms.add(r.getRoom());
            }
        }
        return matchingRooms;

    }

    public Collection<Reservation> getCustomersReservation(Customer customer){
        Set matchingReservations = new HashSet<>();
        for(Reservation r: reservations){
            if(r.getCustomer().equals(customer)){
                matchingReservations.add(r);
            }
        }

        return matchingReservations;

    }

    public void printAllRooms(){
        for(IRoom r: rooms){
            System.out.print(
                r.toString()
            );
        }
    }

//    public void printAllReservation(){
//
//    }

}
