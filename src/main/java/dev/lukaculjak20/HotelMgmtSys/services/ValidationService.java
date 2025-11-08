package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.exceptions.InputTimeoutException;
import dev.lukaculjak20.HotelMgmtSys.exceptions.InvalidDateException;
import dev.lukaculjak20.HotelMgmtSys.exceptions.InvalidPaymentException;
import dev.lukaculjak20.HotelMgmtSys.exceptions.NegativeValueException;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Provides input validation methods
 *
 * @author LukaCuljak20
 * @version 1.0
 * @since 1.3
 */

public class ValidationService {
    //Checked

    /**
     * Checks to see if given date is of a given format and not empty
     * @param date Date we want to check
     * @param pattern Format of the date we want to have
     * @return Given date in given format as LocalDate variable
     * @throws InvalidDateException Date is not of a given format or empty
     */
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

    /**
     * Checks payment method to see if all fields have the exact length and that they are not empty
     * @param cardNumber 16-digit card number
     * @param cardHolder Name and surname of the card owner
     * @param expiryDate Expiration date
     * @param CVV 3-digit security code
     * @throws InvalidPaymentException Field does not satisfy given criteria or is empty
     */
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

    /**
     * Checks if an integer is positive
     * @param value Value we want to check
     * @param fieldName Field where that number corresponds
     * @return Returns given value if it was positive
     */
    public static int validatePositive(int value, String fieldName) {
        if (value < 0) {
            throw new NegativeValueException(fieldName + " cannot be negative: " + value);
        }
        return value;
    }
    /**
     * Checks if an BigDecimal is positive
     * @param value Value we want to check
     * @param fieldName Field where that number corresponds
     * @return Returns given value if it was positive
     */
    public static BigDecimal validatePositive(BigDecimal value, String fieldName) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeValueException(fieldName + " cannot be negative: " + value);
        }
        return value;
    }

    /**
     * Stops the program if input takes too long
     * @param startTime  Time when some input started
     * @param timeoutMilliseconds How long do we wait for the input
     * @param operation Some input or operation we aer checking time length for
     */
    public static void validateInputTimeout(long startTime, long timeoutMilliseconds, String operation){
        long currentTime = System.currentTimeMillis();
        if(currentTime - startTime > timeoutMilliseconds){
            throw new InputTimeoutException(operation + " timed out after: " + timeoutMilliseconds + " ms");
        }
    }

    /**
     * Checks if payment method is empty when it should not be
     * @param value Some value we are checking
     * @param fieldName Field where value should be
     * @return Value without spaces
     * @throws InvalidPaymentException Returns that the value should not be empty
     */
    public static String validateNotEmpty(String value, String fieldName) throws InvalidPaymentException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidPaymentException(fieldName + " cannot be empty");
        }
        return value.trim();
    }

    /**
     * Checks that Room number is in a certain range
     * @param roomNumber Room number we want to check
     * @return Room number if it is in the range
     */
    public static int validateRoomNumber(int roomNumber){
        validatePositive(roomNumber, "Room Number");
        if(roomNumber<0 || roomNumber>1000){
            throw new NegativeValueException("Room Number must be between 0 and 1000");
        }
        return roomNumber;
    }

}
