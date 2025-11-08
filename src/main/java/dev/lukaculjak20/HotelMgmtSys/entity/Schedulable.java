package dev.lukaculjak20.HotelMgmtSys.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Contains information about a schedulable event
 *
 * Sealed class that permits Booking
 *
 * @see dev.lukaculjak20.HotelMgmtSys.entity.Booking
 * @author LukaCuljak20
 * @version 1.0
 * @since 1.2
 */

public sealed interface Schedulable permits Booking{
    /**
     * Gets start date
     *
     * @return returns start date
     */
    LocalDate getStartDate();
    /**
     * Gets end date
     *
     * @return returns end date
     */
    LocalDate getEndDate();

    /**
     * Calculates duration of an event
     *
     * @return Time event lasted expressed in nights
     */
    int getDuration();

    /**
     * Calculates total price for an event
     *
     * Multiples number of nights from getDuration() by some price
     *
     * @return Total price of an event
     */
    BigDecimal  calculateTotalPrice();
}
