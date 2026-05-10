package model;

import java.util.Date;


public class Reservation {

    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutDate;

    public Reservation(Customer customer, IRoom room,  Date checkInDate, Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    @Override
    public String toString() {
        return "Customer: " + customer +
                "\nRoom: " + room +
                "\nCheck-in Date: " + checkInDate +
                "\nCheck-out Date: " + checkOutDate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public IRoom getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }
}
