package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.Hotel;
import dev.lukaculjak20.HotelMgmtSys.entity.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoomService {
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
