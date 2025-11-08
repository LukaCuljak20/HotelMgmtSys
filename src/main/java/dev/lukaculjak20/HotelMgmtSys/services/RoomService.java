package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.Hotel;
import dev.lukaculjak20.HotelMgmtSys.entity.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Searches rooms by certain parameters
 * Searches for a room with a certain name, surname, email, id number or phone number
 *
 * @author LukaCuljak20
 * @version 1.0
 * @since 1.0
 */

public class RoomService {
    /**
     * Searches for a room based on a certain type
     * @param hotel Object which we are searching rooms in
     * @param roomType Comparison parameter
     * @return Array of all the rooms that fulfill the desired parameter
     */
    public static Room[] byRoomType(Hotel hotel, String roomType) {
        Room[] result = new Room[hotel.getListOfRooms().length];
        int count=0;
        for (int i = 0; i < hotel.getListOfRooms().length; i++) {
            if (hotel.getListOfRooms()[i].getType().equalsIgnoreCase(roomType) ) {
                result[count++]= hotel.getListOfRooms()[i];
                System.out.println(hotel.getListOfRooms()[i].getRoomNumber()+" "+hotel.getListOfRooms()[i].getType());
            }
        }
        return result;
    }
    /**
     * Searches for a room cheaper than parameter value
     * @param hotel Object which we are searching rooms in
     * @param comp Comparison parameter
     * @return Array of all the rooms that fulfill the desired parameter
     */
    public static Room[] byRoomCheaperThen(Hotel hotel, int comp){
        Room[] result = new Room[hotel.getListOfRooms().length];
        int count=0;
        for (int i = 0; i < hotel.getListOfRooms().length; i++) {
            if (hotel.getListOfRooms()[i].getPrice().compareTo(BigDecimal.valueOf(comp))<=0){
                result[count++]= hotel.getListOfRooms()[i];
                System.out.println(hotel.getListOfRooms()[i].getRoomNumber()+" "+hotel.getListOfRooms()[i].getPrice().setScale(2, RoundingMode.HALF_UP));
            }
        }
        return result;
    }
    /**
     * Searches for a room more expensive than parameter value
     * @param hotel Object which we are searching rooms in
     * @param comp Comparison parameter
     * @return Array of all the rooms that fulfill the desired parameter
     */
    public static Room[] byMoreExpensiveThen(Hotel hotel, int comp){
        Room[] result = new Room[hotel.getListOfRooms().length];
        int count=0;
        for (int i = 0; i < hotel.getListOfRooms().length; i++) {
            if (hotel.getListOfRooms()[i].getPrice().compareTo(BigDecimal.valueOf(comp))>=0){
                result[count++]= hotel.getListOfRooms()[i];
                System.out.println(hotel.getListOfRooms()[i].getRoomNumber()+" "+hotel.getListOfRooms()[i].getPrice().setScale(2, RoundingMode.HALF_UP));
            }
        }
        return result;
    }
    /**
     * Searches for the cheapest room
     * @param hotel Object which we are searching rooms in
     * @return Room that fulfills given condition
     */
    public static Room byRoomPriceMinimum(Hotel hotel){
        Room result = hotel.getListOfRooms()[0];
        for (int i = 0; i < hotel.getListOfRooms().length; i++) {
            if (hotel.getListOfRooms()[i].getPrice().compareTo(result.getPrice())<0) {
                result = hotel.getListOfRooms()[i];
            }
        }
        System.out.println(result.getRoomNumber()+" "+result.getPrice().setScale(2, RoundingMode.HALF_UP));
        return result;
    }
    /**
     * Searches for the most expensive room
     * @param hotel Object which we are searching rooms in
     * @return Room that fulfills given condition
     */
    public static Room byRoomPriceMaximum(Hotel hotel){
        Room result = hotel.getListOfRooms()[0];
        for (int i = 0; i < hotel.getListOfRooms().length; i++) {
            if (hotel.getListOfRooms()[i].getPrice().compareTo(result.getPrice())>0) {
                result = hotel.getListOfRooms()[i];
            }
        }
        System.out.println(result.getRoomNumber()+" "+result.getPrice().setScale(2, RoundingMode.HALF_UP));
        return result;
    }
}
