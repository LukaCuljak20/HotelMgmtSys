package dev.lukaculjak20.HotelMgmtSys.entity;

import java.time.LocalDate;

public record PaymentInfo(String cardNumber, String cardHolder, LocalDate expiryDate,String cvv) {
    public boolean isValid(){
        return cardNumber != null && !cardNumber.isEmpty() &&
                cardHolder != null && !cardHolder.isEmpty() &&
                expiryDate != null && expiryDate.isAfter(LocalDate.now()) &&
                cvv != null && cvv.length() == 3;
    }
}
