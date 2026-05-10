package model;

public class Room implements IRoom{

    public int roomIdNumber;
    String roomNumber;
    Double price;
    RoomType roomType;

    public Room(String roomNumber, RoomType roomType, double price){
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

    public int getRoomIdNumber(){
        return roomIdNumber;
    }
    public void setRoomIdNumber(int roomIdNumber){
        this.roomIdNumber = roomIdNumber;
    }


    @Override
    public String toString() {

        String strRoomType = "single room";
        if(roomType == RoomType.DOUBLE){
            strRoomType = "double bed room";
        }
        return "Room number '" + roomNumber +  "' is a " + strRoomType + ". \n"
                + "It costs $" + price + ". It has room id: " + this.roomId() + "\n";
    }

    public String roomId(){
        if(roomType == RoomType.DOUBLE){
            return "p_" + roomNumber + "_2";
        }
        return "p_" + roomNumber + "_1";
    }




}
