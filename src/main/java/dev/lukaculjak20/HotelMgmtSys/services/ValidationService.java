package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.exceptions.InputTimeoutException;
import dev.lukaculjak20.HotelMgmtSys.exceptions.InvalidDateException;
import dev.lukaculjak20.HotelMgmtSys.exceptions.InvalidPaymentException;
import dev.lukaculjak20.HotelMgmtSys.exceptions.NegativeValueException;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ValidationService {
    //Checked: validateDate, validatePayment
    public static LocalDate validateDate(String date,String pattern) throws InvalidDateException {
        if (date == null || date.trim().isEmpty()) {
            throw new InvalidDateException("Date cannot be Empty");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDate.parse(date, formatter);
        }
        catch (DateTimeException e) {
            throw new InvalidDateException("Invalid Date Format. Use: " + pattern);
        }
    }

    public static void validatePayment(String cardNumber,String cardHolder, LocalDate expiryDate, String CVV) throws InvalidPaymentException {
        if (cardNumber == null || cardNumber.length() != 16 ){
            throw new InvalidPaymentException("Invalid Card Number, must be 16 digits ");
        }
        if(cardHolder == null || cardHolder.trim().isEmpty()){
            throw new InvalidPaymentException("Card holder name is required ");
        }
        if(expiryDate == null||expiryDate.isBefore(LocalDate.now())){
            throw new InvalidPaymentException("Expiry Date is invalid ore expired ");
        }
        if(CVV == null || CVV.trim().length()!=3){
            throw new InvalidPaymentException("CVV value must be 3 characters ");
        }
    }
    // Unchecked

    public static int validatePositive(int value, String fieldName) {
        if (value < 0) {
            throw new NegativeValueException(fieldName + " cannot be negative: " + value);
        }
        return value;
    }

    public static BigDecimal validatePositive(BigDecimal value, String fieldName) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeValueException(fieldName + " cannot be negative: " + value);
        }
        return value;
    }

    public static void validateInputTimeout(long startTime, long timeoutMilliseconds, String operation){
        long currentTime = System.currentTimeMillis();
        if(currentTime - startTime > timeoutMilliseconds){
            throw new InputTimeoutException(operation + " timed out after: " + timeoutMilliseconds + " ms");
        }
    }

    public static String validateNotEmpty(String value, String fieldName) throws InvalidPaymentException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidPaymentException(fieldName + " cannot be empty");
        }
        return value.trim();
    }

    public static int validateRoomNumber(int roomNumber){
        validatePositive(roomNumber, "Room Number");
        if(roomNumber<0 || roomNumber>1000){
            throw new NegativeValueException("Room Number must be between 0 and 1000");
        }
        return roomNumber;
    }

}
