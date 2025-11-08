package dev.lukaculjak20.HotelMgmtSys.exceptions;

public class InputTimeoutException extends RuntimeException {
  public InputTimeoutException(String message) {
    super(message);
  }
}
