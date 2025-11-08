package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.*;
import dev.lukaculjak20.HotelMgmtSys.exceptions.InvalidDateException;
import dev.lukaculjak20.HotelMgmtSys.exceptions.InvalidPaymentException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Inputs all data for any number of hotels
 *
 *
 * @author LukaCuljak20
 * @version 1.3
 * @since 1.0
 */

public class InputService {
    private final Scanner scanner = new Scanner(System.in);
    private final String dateFormat = "dd.MM.yyyy";

    private PaymentInfo readPaymentInfo() throws InvalidPaymentException, InvalidDateException {
        System.out.println("PAYMENT INFO:");

        System.out.println("Card Number: ");
        String cardNumber = scanner.nextLine();

        System.out.println("Card holder: ");
        String cardHolder = scanner.nextLine();

        System.out.println("Card expiration date (dd.mm.yyyy): ");
        LocalDate expiryDate = ValidationService.validateDate(scanner.nextLine(), "dd.MM.yyyy");

        System.out.println("CVV: ");
        String cvv = scanner.nextLine();

        ValidationService.validatePayment(cardNumber, cardHolder, expiryDate, cvv);

        return new PaymentInfo(cardNumber, cardHolder, expiryDate, cvv);
    }

    /**
     * Prompts and takes all the information for any desired number of hotels
     * @return Array of hotels with all the inputted information
     */

    public Hotel[] hotelDataEntry() {
        try {
            System.out.println("Enter number of hotels: ");
            Integer numberOfHotels = ValidationService.validatePositive(scanner.nextInt(), "Number of hotels");
            scanner.nextLine();
            Hotel[] hotels = new Hotel[numberOfHotels];
            for (int i = 0; i < hotels.length; i++) {

                System.out.println("Enter the " + (i + 1) + ". hotels name: ");
                String hotelName = scanner.nextLine();

                System.out.println("Enter the number of employees: ");
                int employeeNum = ValidationService.validatePositive(scanner.nextInt(), "Number of employees");
                Employee[] employee = new Employee[employeeNum];
                scanner.nextLine();
                for (int j = 0; j < employeeNum; j++) {
                    System.out.println("Enter the " + (j + 1) + ". employee name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the " + (j + 1) + ". employee surname: ");
                    String surname = scanner.nextLine();
                    System.out.println("Enter the " + (j + 1) + ". employee email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter the " + (j + 1) + ". employee id: ");
                    String employeeId = scanner.nextLine();

                    employee[j] = new Employee(name, surname, email, employeeId);
                }

                System.out.println("Enter the number of rooms ");
                Integer numberOfRooms = ValidationService.validatePositive(scanner.nextInt(), "Number of rooms");
                scanner.nextLine();
                Room[] rooms = new Room[numberOfRooms];
                for (int j = 0; j < numberOfRooms; j++) {
                    System.out.println("Enter the " + (j + 1) + ". room number: ");
                    Integer roomN = ValidationService.validateRoomNumber(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter the " + (j + 1) + ". room type: ");
                    String roomType = scanner.nextLine();
                    System.out.println("Enter the " + (j + 1) + ". room price: ");
                    BigDecimal price = ValidationService.validatePositive(scanner.nextBigDecimal(), "Price of room");
                    scanner.nextLine();
                    System.out.println("Enter the " + (j + 1) + ". room availability: ");
                    boolean availability = scanner.nextBoolean();
                    scanner.nextLine();
                    rooms[j] = new Room(roomN, roomType, price, availability);
                }
                System.out.println("Enter the number of bookings: ");
                Integer numberOfBooking = scanner.nextInt();
                scanner.nextLine();
                Booking[] bookings = new Booking[numberOfBooking];
                for (int j = 0; j < numberOfBooking; j++) {
                    System.out.println("Enter the " + (j + 1) + ". booking number of guests: ");
                    Integer numberOfGuests = scanner.nextInt();
                    scanner.nextLine();
                    Guest[] guests = new Guest[numberOfGuests];
                    for (int k = 0; k < numberOfGuests; k++) {
                        System.out.println("Enter the " + (k + 1) + ". guest name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the " + (k + 1) + ". guest surname: ");
                        String surname = scanner.nextLine();
                        System.out.println("Enter the " + (k + 1) + ". guest email: ");
                        String email = scanner.nextLine();
                        System.out.println("Enter the " + (k + 1) + ". guest phone number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter the " + (k + 1) + ". guest id number: ");
                        String guestId = scanner.nextLine();
                        guests[k] = new Guest(name, surname, email, phoneNumber, guestId);
                    }
                    System.out.println("Enter the " + (i + 1) + ". booking room: ");
                    for (int k = 0; k < numberOfRooms; k++) {
                        System.out.println((k + 1) + ". Room number: " + rooms[k].getRoomNumber() + " Room type: " + rooms[k].getType() + " Price: " + rooms[k].getPrice());
                    }
                    Integer rNum = scanner.nextInt();
                    scanner.nextLine();
                    rNum--;
                    System.out.println("Enter the " + (i + 1) + ". booking check in date(dd.mm.yyyy): ");
                    LocalDate checkInDate = ValidationService.validateDate(scanner.nextLine(), dateFormat);
                    System.out.println("Enter the " + (i + 1) + ". booking check out date(dd.MM.yyyy): ");
                    LocalDate checkOutDate = ValidationService.validateDate(scanner.nextLine(), dateFormat);

                    PaymentInfo paymentInfo = readPaymentInfo();
                    bookings[j] = new Booking(guests, rooms[rNum], checkInDate, checkOutDate, paymentInfo);
                }
                hotels[i] = new Hotel(hotelName, rooms, bookings);

            }
            return hotels;
        }
        catch (InvalidDateException | InvalidPaymentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please try again");
            return hotelDataEntry();
        }
    }
}
