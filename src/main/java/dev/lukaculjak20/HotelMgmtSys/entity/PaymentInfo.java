package dev.lukaculjak20.HotelMgmtSys.entity;

import java.time.LocalDate;

/**
 * Stores payment information
 *
 * @param cardNumber 16-digit card number
 * @param cardHolder Name and Surname of a card owner
 * @param expiryDate Expiration date of the card
 * @param cvv 3-digit number security code
 */

public record PaymentInfo(String cardNumber, String cardHolder, LocalDate expiryDate,String cvv) {
    public boolean isValid(){
        return cardNumber != null && !cardNumber.isEmpty() &&
                cardHolder != null && !cardHolder.isEmpty() &&
                expiryDate != null && expiryDate.isAfter(LocalDate.now()) &&
                cvv != null && cvv.length() == 3;
    }
}
