package dev.lukaculjak20.HotelMgmtSys.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public sealed interface Schedulable permits Booking{
    LocalDate getStartDate();
    LocalDate getEndDate();
    int getDuration();
    BigDecimal  calculateTotalPrice();
}
