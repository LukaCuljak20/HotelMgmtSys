package dev.lukaculjak20.HotelMgmtSys.exceptions;

/**
 * Describes exception thrown when input data is invalid
 */

public class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}
