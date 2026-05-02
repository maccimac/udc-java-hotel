package service;

import java.util.PriorityQueue;
import java.util.Queue;

import model.Reservation;


public class ReservationService {

    Queue<Reservation> reservations = new PriorityQueue<Reservation>();
    public static ReservationService(){

    }
    public void addRoom(IRoom room){

    }
    public IRoom getARoom(String roomId){

    }
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

    }
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

    }
    public Collection<Reservation> getCustomersReservation(Customer customer){

    }
    public void printAllReservation(){

    }
}
