package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.Booking;
import dev.lukaculjak20.HotelMgmtSys.entity.Guest;
import dev.lukaculjak20.HotelMgmtSys.entity.Hotel;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Searches guests by certain parameters
 * Searches for a guest with a certain name, surname, email, id number or phone number
 *
 * @author LukaCuljak20
 * @version 1.4
 * @since 1.0
 */

public class GuestService {
    public static void print(Guest guest){
        System.out.println("Full name: " + guest.getFullName() + " ID number: " + guest.getIdNumber());
    }
    public static void print(Set<Guest> guests){
        for(Guest guest : guests){
            System.out.println("Full name: " + guest.getFullName() + " ID number: " + guest.getIdNumber());
        }

    }
    /**
     * Searches for a guest/s with a certain name
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired name)
     * @return Set of guests satisfying certain criteria
     */
    public static Set<Guest> byName(Hotel hotel, String comp) {
        return hotel.getListOfBookings().stream().map(Booking::getGuests).flatMap(Collection::stream).filter(guest -> guest.getFirstName().equalsIgnoreCase(comp)).collect(Collectors.toSet());
    }
    /**
     * Searches for a guest/s with a certain surname
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired surname)
     * @return Set of guests satisfying certain criteria
     */
    public static Set<Guest> bySurname(Hotel hotel,String comp) {
        return hotel.getListOfBookings().stream().map(Booking::getGuests).flatMap(Collection::stream).filter(guest -> guest.getLastName().equalsIgnoreCase(comp)).collect(Collectors.toSet());
    }
    /**
     * Searches for a guest/s with a certain email
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired email)
     * @return Set of guests satisfying certain criteria
     */
    public static Set<Guest> byEmail(Hotel hotel,String comp) {
        return hotel.getListOfBookings().stream().map(Booking::getGuests).flatMap(Collection::stream).filter(guest -> guest.getEmail().equalsIgnoreCase(comp)).collect(Collectors.toSet());
    }
    /**
     * Searches for a guest/s with a certain ID number
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired ID number)
     * @return Set of guests satisfying certain criteria
     */
    public static Set<Guest> byIdNumber(Hotel hotel,String comp) {
        return hotel.getListOfBookings().stream().map(Booking::getGuests).flatMap(Collection::stream).filter(guest -> guest.getIdNumber().equalsIgnoreCase(comp)).collect(Collectors.toSet());
    }
    /**
     * Searches for a guest/s with a certain phone number
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired phone number)
     * @return Set of guests satisfying certain criteria
     */
    public static Set<Guest> byPhoneNumber(Hotel hotel,String comp) {
        return hotel.getListOfBookings().stream().map(Booking::getGuests).flatMap(Collection::stream).filter(guest -> guest.getPhoneNumber().equalsIgnoreCase(comp)).collect(Collectors.toSet());
    }
}
