package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.Guest;
import dev.lukaculjak20.HotelMgmtSys.entity.Hotel;

/**
 * Searches guests by certain parameters
 * Searches for a guest with a certain name, surname, email, id number or phone number
 *
 * @author LukaCuljak20
 * @version 1.0
 * @since 1.0
 */

public class GuestService {
    /**
     * Searches for a guest/s with a certain name
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired name)
     * @return Array of guests satisfying certain criteria
     */
    public static Guest[] byName(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getFirstName().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
    /**
     * Searches for a guest/s with a certain surname
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired surname)
     * @return Array of guests satisfying certain criteria
     */
    public static Guest[] bySurname(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getLastName().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
    /**
     * Searches for a guest/s with a certain email
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired email)
     * @return Array of guests satisfying certain criteria
     */
    public static Guest[] byEmail(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getEmail().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
    /**
     * Searches for a guest/s with a certain ID number
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired ID number)
     * @return Array of guests satisfying certain criteria
     */
    public static Guest[] byIdNumber(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getIdNumber().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
    /**
     * Searches for a guest/s with a certain phone number
     * @param hotel Object which we are trying to find a guest in
     * @param comp Comparison value (desired phone number)
     * @return Array of guests satisfying certain criteria
     */
    public static Guest[] byPhoneNumber(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getPhoneNumber().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
}
