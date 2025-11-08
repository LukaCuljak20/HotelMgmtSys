package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.Booking;
import dev.lukaculjak20.HotelMgmtSys.entity.Hotel;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Searches a booking by certain parameters
 * Searches for a booking with the lowest or highest total price,
 * or a booking with minimum or maximum total price of a certain value
 *
 * @author LukaCuljak20
 * @version 1.0
 * @since 1.0
 */

public class BookingService {
    /**
     * Searches for a booking with total price higher than comparison value
     * @param hotel Object for which we are searching bookings in
     * @param comp Comparison value
     * @return Array of bookings that satisfy the criteria
     */
    public static Booking[] byTotalPriceHigher(Hotel hotel,int comp){
        Booking[] result = new Booking[hotel.getListOfBookings().length];
        int count =0;
        for(int i=0;i<hotel.getListOfBookings().length;i++){
            if (hotel.getListOfBookings()[i].getTotalPrice().compareTo(BigDecimal.valueOf(comp))>=0){
                result[count++]=hotel.getListOfBookings()[i];
                System.out.println(hotel.getListOfBookings()[i].getRoom().getRoomNumber()+" "+hotel.getListOfBookings()[i].getTotalPrice().setScale(2, RoundingMode.HALF_UP));
            }
        }
        return result;
    }
    /**
     * Searches for a booking with total price lower than comparison value
     * @param hotel Object for which we are searching bookings in
     * @param comp Comparison value
     * @return Array of bookings that satisfy the criteria
     */
    public static Booking[] byTotalPriceLower(Hotel hotel,int comp){
        Booking[] result = new Booking[hotel.getListOfBookings().length];
        int count=0;
        for(int i=0;i<hotel.getListOfBookings().length;i++){
            if (hotel.getListOfBookings()[i].getTotalPrice().compareTo(BigDecimal.valueOf(comp))<=0){
                result[count++]=hotel.getListOfBookings()[i];
                System.out.println(hotel.getListOfBookings()[i].getRoom().getRoomNumber()+" "+hotel.getListOfBookings()[i].getTotalPrice().setScale(2, RoundingMode.HALF_UP));
            }
        }
        return result;
    }
    /**
     * Searches for a booking with the lowest total price
     * @param hotel Object for which we are searching bookings in
     * @return Array of bookings that satisfy the criteria
     */
    public static Booking byTotalPriceMinimum(Hotel hotel){
        Booking result = hotel.getListOfBookings()[0];
        for(int i=0;i<hotel.getListOfBookings().length;i++){
            if (hotel.getListOfBookings()[i].getTotalPrice().compareTo(result.getTotalPrice())<0){
                result=hotel.getListOfBookings()[i];
            }
        }
        System.out.println(result.getRoom().getRoomNumber()+" "+result.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
        return result;
    }
    /**
     * Searches for a booking with the highest total price
     * @param hotel Object for which we are searching bookings in
     * @return Array of bookings that satisfy the criteria
     */
    public static Booking byTotalPriceMaximum(Hotel hotel){
        Booking result = hotel.getListOfBookings()[0];
        for(int i=0;i<hotel.getListOfBookings().length;i++){
            if (hotel.getListOfBookings()[i].getTotalPrice().compareTo(result.getTotalPrice())>0){
                result=hotel.getListOfBookings()[i];
            }
        }
        System.out.println(result.getRoom().getRoomNumber()+" "+result.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
        return result;
    }
}
