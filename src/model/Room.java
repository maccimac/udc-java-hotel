package model;

public class Room implements IRoom{

    String roomNumber;
    Double price;
    RoomType roomType;

    public Room(String roomNumber, double price, RoomType roomType){
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    public String getRoomNumber(){
        return roomNumber;
    }
    public Double getRoomPrice(){
        return price;
    }
    public RoomType getRoomType(){
        return roomType;
    }
    public boolean isFree(){
        return false;
    }

    @Override
    public String toString() {

        String strRoomType = "single room";
        if(roomType == RoomType.DOUBLE){
            strRoomType = "double bed room";
        }
        return "Room# " + roomNumber + "is a " + strRoomType + ". \n"
                + "It costs $" + price;
    }
}
