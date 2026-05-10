package model;

public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree();

    public String roomId();

    public int getRoomIdNumber();
    public void setRoomIdNumber(int i);
}
