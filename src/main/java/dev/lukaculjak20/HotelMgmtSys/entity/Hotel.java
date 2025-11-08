package dev.lukaculjak20.HotelMgmtSys.entity;

/**
 * Describes a hotel
 *
 * @author LukaCuljak20
 * @version 1.2
 * @since 1.0
 */

public class Hotel {
    private String hotelName;
    private Room[] listOfRooms;
    private Booking[] listOfBookings;

    /**
     * Getter for hotel's name
     * @return Hotel's name
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Lists rooms in a hotel
     * @return Array of rooms in a hotel
     */

    public Room[] getListOfRooms() {
        return listOfRooms;
    }

    /**
     * Lists bookings in a hotel
     * @return Array of bookings in a hotel
     */

    public Booking[] getListOfBookings() {
        return listOfBookings;
    }

    /**
     * Sets hotel name to string in parameter
     * @param hotelName Desired hotel name
     */

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Sets hotel rooms to an array given as a parameter
     * @param listOfRooms Array of rooms to be set as hotel's rooms
     */

    public void setListOfRooms(Room[] listOfRooms) {
        this.listOfRooms = listOfRooms;
    }

    /**
     * Sets hotel's bookings to array of bookings given in the parameter
     * @param listOfBookings Array of booking to be set as hotel's bookings
     */

    public void setListOfBookings(Booking[] listOfBookings) {
        this.listOfBookings = listOfBookings;
    }

    /**
     * Constructs hotel object
     * @param hotelName Hotel's name
     * @param listOfRooms List of rooms inside the hotel
     * @param listOfBookings List of bookings inside hotel
     */

    public Hotel(String hotelName, Room[] listOfRooms, Booking[] listOfBookings) {
        this.hotelName = hotelName;
        this.listOfRooms = listOfRooms;
        this.listOfBookings = listOfBookings;
    }
}

