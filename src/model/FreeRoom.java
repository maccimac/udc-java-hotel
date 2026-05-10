package model;

public class FreeRoom implements IRoom{

    public int roomIdNumber;
    String roomNumber;
    RoomType roomType;

    public FreeRoom(String roomNumber, RoomType roomType){
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
        return "Room number '" + roomNumber + "' is a " + strRoomType + ". \n"
                + "It is a free room. It is room id: " + this.roomId() +  "\n";
    }

    public String roomId(){
        if(roomType == RoomType.DOUBLE){
            return "f_" + roomNumber + "_2";
        }
        return "f_" + roomNumber + "_1";
    }
}
