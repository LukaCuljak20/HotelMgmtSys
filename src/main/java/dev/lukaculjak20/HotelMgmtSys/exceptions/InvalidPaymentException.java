package dev.lukaculjak20.HotelMgmtSys.exceptions;

/**
 * Describes exception thrown when payment method is invalid
 */

public class InvalidPaymentException extends Exception {
    public InvalidPaymentException(String message) {
        super(message);
    }
}
