package dev.lukaculjak20.HotelMgmtSys.exceptions;

/**
 * Describes exception thrown when some value should be positive but isn't
 */

public class NegativeValueException extends RuntimeException {
    public NegativeValueException(String message) {
        super(message);
    }
}
