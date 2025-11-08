package dev.lukaculjak20.HotelMgmtSys.entity;

public class Hotel {
    private String hotelName;
    private Room[] listOfRooms;
    private Booking[] listOfBookings;

    public String getHotelName() {
        return hotelName;
    }

    public Room[] getListOfRooms() {
        return listOfRooms;
    }

    public Booking[] getListOfBookings() {
        return listOfBookings;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setListOfRooms(Room[] listOfRooms) {
        this.listOfRooms = listOfRooms;
    }

    public void setListOfBookings(Booking[] listOfBookings) {
        this.listOfBookings = listOfBookings;
    }

    public Hotel(String hotelName, Room[] listOfRooms, Booking[] listOfBookings) {
        this.hotelName = hotelName;
        this.listOfRooms = listOfRooms;
        this.listOfBookings = listOfBookings;
    }
}

