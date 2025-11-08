package dev.lukaculjak20.HotelMgmtSys.entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *  Contains information about Booking
 *  Implements Schedulable interface  and overrides functions
 *
 * @see dev.lukaculjak20.HotelMgmtSys.entity.Schedulable
 * @author LukaCuljak20
 * @version 1.2
 * @since 1.0
 */

public final class Booking implements Schedulable {
    private Guest[] guests;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private BigDecimal totalPrice;
    private PaymentInfo paymentInfo;

    public Booking(Guest[] guests, Room room, LocalDate checkIn, LocalDate checkOut, PaymentInfo paymentInfo) {
        this.guests = guests;
        this.room = room;
        room.makeReservation();
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = calculateTotalPrice();
    }


    /**
     * Gets array of guests
     *
     * @return array of guests
     */
    public Guest[] getGuest() {
        return guests;
    }

    /**
     * Gets a room including all room aspects
     *
     * @return Returns some room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Gets check in date
     *
     * @return Check in date
     */

    public LocalDate getCheckIn() {
        return checkIn;
    }

    /**
     * Gets check out date
     * @return Check out date
     */
    public LocalDate getCheckOut() {
        return checkOut;
    }

    /**
     * Gets total price of the booking
     * @return Total price in big decimal
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets object guest value to parameter value
     *
     * @param guests value to be assigned to guests inside of this object
     */
    public void setGuests(Guest[] guests) {
        this.guests = guests;
    }
    /**
     * Sets object room value to parameter value
     *
     * @param room value to be assigned to room inside of this object
     */
    public void setRoom(Room room) {
        this.room = room;
    }
    /**
     * Sets object check in date to parameter value
     *
     * @param checkIn date to be assigned to check in date inside of this object
     */
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
    /**
     * Sets object check out date to parameter value
     *
     * @param checkOut date to be assigned to check out date inside of this object
     */
    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }



    @Override
    public LocalDate getStartDate() {
        return checkIn;
    }


    @Override
    public LocalDate getEndDate() {
        return checkOut;
    }


    @Override
    public int getDuration() {
        return (int) ChronoUnit.DAYS.between(checkIn, checkOut);
    }


    @Override
    public BigDecimal calculateTotalPrice() {
        return room.getPrice().multiply(new BigDecimal(getDuration()));
    }

}
