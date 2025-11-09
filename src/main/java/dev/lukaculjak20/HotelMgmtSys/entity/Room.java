package dev.lukaculjak20.HotelMgmtSys.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *Describes a hotel room
 * Implements Reservable for checking availability
 *
 * @see dev.lukaculjak20.HotelMgmtSys.entity.Reservable
 * @author LukaCuljak20
 * @version 1.2
 * @since 1.0
 */
public class Room implements Reservable {
    private String type;
    private BigDecimal price;
    private boolean availability = true;


    /**
     * Gets room-s type
     * @return Room's type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets Room price for 1 night
     * @return Price per night
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Gets availability of the room
     * @return Is teh room available or not
     */
    public Boolean getAvailability() {
        return availability;
    }


    /**
     * Sets room type to parameter value
     * @param type Desired room type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets price of the room per 1 night
     * @param price Desired room price for 1 night
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Constructs room object
     *
     * @param type         Room type
     * @param price        Room price for 1 night
     * @param availability Room availability
     */
    public Room(String type, BigDecimal price, boolean availability) {
        this.type = type;
        this.price = price;
        this.availability = availability;
    }

    @Override
    public boolean isAvailable(LocalDate checkIn, LocalDate checkOut) {
        return availability && checkIn != null && checkOut != null && checkOut.isAfter(checkIn);
    }


    @Override
    public void makeReservation() {
        this.availability = false;
    }

    @Override
    public void cancelReservation() {
        this.availability = true;
    }
}
