package dev.lukaculjak20.HotelMgmtSys.entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

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
        room.setAvailability(false);
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = calculateTotalPrice();
    }


    public Guest[] getGuest() {
        return guests;
    }
    public Room getRoom() {
        return room;
    }
    public LocalDate getCheckIn() {
        return checkIn;
    }
    public LocalDate getCheckOut() {
        return checkOut;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void setGuests(Guest[] guests) {
        this.guests = guests;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
