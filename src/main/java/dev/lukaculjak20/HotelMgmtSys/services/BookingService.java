package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.Booking;
import dev.lukaculjak20.HotelMgmtSys.entity.Hotel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;

/**
 * Searches a booking by certain parameters
 * Searches for a booking with the lowest or highest total price,
 * or a booking with minimum or maximum total price of a certain value
 *
 * @author LukaCuljak20
 * @version 1.4
 * @since 1.0
 */

public class BookingService {
    public static void print(Booking booking){
        System.out.println("Room type: " + booking.getRoom().getType() + " Total price: " + booking.getTotalPrice());
    }
    public static void print(List <Booking> booking){
        for(Booking book : booking){
            System.out.println("Room type: " + book.getRoom().getType() + " Total price: " + book.getTotalPrice());
        }

    }
    /**
     * Searches for a booking with total price higher than comparison value
     * @param hotel Object for which we are searching bookings in
     * @param comp Comparison value
     * @return List of bookings that satisfy the criteria
     */
    public static List<Booking> byTotalPriceHigher(Hotel hotel, int comp){
        return hotel.getListOfBookings().stream().filter(booking -> booking.getTotalPrice().compareTo(BigDecimal.valueOf(comp))>=0).toList();
    }
    /**
     * Searches for a booking with total price lower than comparison value
     * @param hotel Object for which we are searching bookings in
     * @param comp Comparison value
     * @return List of bookings that satisfy the criteria
     */
    public static List<Booking> byTotalPriceLower(Hotel hotel,int comp){
        return hotel.getListOfBookings().stream().filter(booking -> booking.getTotalPrice().compareTo(BigDecimal.valueOf(comp))<=0).toList();
    }
    /**
     * Searches for a booking with the lowest total price
     * @param hotel Object for which we are searching bookings in
     * @return List of bookings that satisfy the criteria
     */
    public static Booking byTotalPriceMinimum(Hotel hotel){
        return hotel.getListOfBookings().stream().min(Comparator.comparing(Booking::getTotalPrice)).orElse(null);
    }
    /**
     * Searches for a booking with the highest total price
     * @param hotel Object for which we are searching bookings in
     * @return List of bookings that satisfy the criteria
     */
    public static Booking byTotalPriceMaximum(Hotel hotel) {
        return hotel.getListOfBookings().stream().max(Comparator.comparing(Booking::getTotalPrice)).orElse(null);
    }

    /**
     * Sorts bookings by total price
     *
     * Using built in comparator
     * @param hotel Object for which we are searching bookings in
     * @return List of bookings that satisfy the criteria
     */
    public static List<Booking> sortedByTotalPrice(Hotel hotel) {
        return hotel.getListOfBookings().stream().sorted(Comparator.comparing(Booking::getTotalPrice)).toList();
    }

    /**
     * Sorts bookings by total price in reversed order
     *
     * Using lambda expression as a comparator
     * @param hotel Object for which we are searching bookings in
     * @return List of bookings that satisfy the criteria
     */
    public static List<Booking> sortedByTotalPriceReversed(Hotel hotel) {
        return hotel.getListOfBookings().stream().sorted((booking1,booking2) -> booking2.getTotalPrice().compareTo(booking1.getTotalPrice())).toList();
    }
}
