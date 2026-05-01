package model;

public class FreeRoom implements IRoom{

    String roomNumber;
    RoomType roomType;

    public FreeRoom(String roomNumber, double price, RoomType roomType){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public String getRoomNumber(){
        return roomNumber;
    }
    public Double getRoomPrice(){
        return 0.00;
    }
    public RoomType getRoomType(){
        return roomType;
    }
    public boolean isFree(){
        return true;
    }

    @Override
    public String toString() {

        String strRoomType = "single room";
        if(roomType == RoomType.DOUBLE){
            strRoomType = "double bed room";
        }
        return "Room# " + roomNumber + "is a " + strRoomType + ". \n"
                + "It is a free room.";
    }
}
