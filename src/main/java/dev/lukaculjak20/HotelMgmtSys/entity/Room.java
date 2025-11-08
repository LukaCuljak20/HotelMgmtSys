package dev.lukaculjak20.HotelMgmtSys.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class Room implements Reservable {
    private Integer roomNumber;
    private String type;
    private BigDecimal price;
    private boolean availability;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Room(Integer roomNumber, String type, BigDecimal price, boolean availability) {
        this.roomNumber = roomNumber;
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
