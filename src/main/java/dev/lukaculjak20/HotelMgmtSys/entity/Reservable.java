package dev.lukaculjak20.HotelMgmtSys.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reservable {
    boolean isAvailable(LocalDate checkIn, LocalDate checkOut);
    void makeReservation();
    void cancelReservation();

}
