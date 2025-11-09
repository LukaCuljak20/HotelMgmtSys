package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.Hotel;
import dev.lukaculjak20.HotelMgmtSys.entity.Room;

import java.math.BigDecimal;

import java.util.Comparator;
import java.util.List;

/**
 * Searches rooms by certain parameters
 * Searches for a room with a certain name, surname, email, id number or phone number
 *
 * @author LukaCuljak20
 * @version 1.4
 * @since 1.0
 */

public class RoomService {
    public static void print(Room room) {
        System.out.println("Room type: "  + room.getType() + " Room price per night: " + room.getPrice());
    }
    public static void print(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.println("Room type: "  + room.getType() + " Room price per night: " + room.getPrice());
        }
    }
    /**
     * Searches for a room based on a certain type
     * @param hotel Object which we are searching rooms in
     * @param roomType Comparison parameter
     * @return List of all the rooms that fulfill the desired parameter
     */
    public static List<Room> byRoomType(Hotel hotel, String roomType) {
        return hotel.getListOfRooms().values().stream().filter(room -> room.getType().equalsIgnoreCase(roomType)).toList();
    }
    /**
     * Searches for a room cheaper than parameter value
     * @param hotel Object which we are searching rooms in
     * @param comp Comparison parameter
     * @return List of all the rooms that fulfill the desired parameter
     */
    public static List<Room> byRoomCheaperThen(Hotel hotel, int comp){
        return hotel.getListOfRooms().values().stream().filter(room -> room.getPrice().compareTo(BigDecimal.valueOf(comp))<=0).toList();
    }
    /**
     * Searches for a room more expensive than parameter value
     * @param hotel Object which we are searching rooms in
     * @param comp Comparison parameter
     * @return List of all the rooms that fulfill the desired parameter
     */
    public static List<Room> byMoreExpensiveThen(Hotel hotel, int comp){
        return hotel.getListOfRooms().values().stream().filter(room -> room.getPrice().compareTo(BigDecimal.valueOf(comp))>=0).toList();
    }
    /**
     * Searches for the cheapest room
     * @param hotel Object which we are searching rooms in
     * @return Room that fulfills given condition
     */
    public static Room byRoomPriceMinimum(Hotel hotel){
        return hotel.getListOfRooms().values().stream().min(Comparator.comparing(Room::getPrice)).orElse(null);
    }
    /**
     * Searches for the most expensive room
     * @param hotel Object which we are searching rooms in
     * @return Room that fulfills given condition
     */
    public static Room byRoomPriceMaximum(Hotel hotel){
        return hotel.getListOfRooms().values().stream().max(Comparator.comparing(Room::getPrice)).orElse(null);
    }
}
