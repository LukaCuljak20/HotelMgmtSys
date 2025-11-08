package dev.lukaculjak20.HotelMgmtSys.exceptions;

/**
 * Describes exception thrown when input takes too long
 */

public class InputTimeoutException extends RuntimeException {
    public InputTimeoutException(String message) {
        super(message);
    }
}
