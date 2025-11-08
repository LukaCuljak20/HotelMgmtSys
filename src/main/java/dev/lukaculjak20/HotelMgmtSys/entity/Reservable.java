package dev.lukaculjak20.HotelMgmtSys.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Gives functionality for Reservable events
 *
 * @author LukaCuljak20
 * @version 1.0
 * @since 1.2
 */

public interface Reservable {
    /**
     * Checks room availability
     *
     * @param checkIn Check in date of a guest
     * @param checkOut Check in date of a guest
     * @return True or False depending on availability
     */
    boolean isAvailable(LocalDate checkIn, LocalDate checkOut);

    /**
     * Changes room availability to false
     */
    void makeReservation();
    /**
     * Changes room availability to true
     */
    void cancelReservation();

}
