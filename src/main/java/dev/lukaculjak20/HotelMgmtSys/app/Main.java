package dev.lukaculjak20.HotelMgmtSys.app;

import ch.qos.logback.classic.Logger;
import dev.lukaculjak20.HotelMgmtSys.services.*;
import dev.lukaculjak20.HotelMgmtSys.entity.*;
import org.slf4j.LoggerFactory;


import java.util.Scanner;


/**
 * Runs and connects all other programs in this project
 *
 * Runs input and implements all the services for searching
 *
 * @author LukaCuljak20
 * @version 1.3
 * @since 1.0
 */

public class Main {
    public static final Logger logger = (Logger) LoggerFactory.getLogger(Main.class);
    private static Scanner scanner = new Scanner(System.in);
    static void main(String[] args) {
    InputService inputService = new InputService();
    logger.info("Main started...");

    Hotel[] hotels = inputService.hotelDataEntry();

        System.out.println("Choose hotel: ");
        for (int i = 0; i < hotels.length; i++) {
            System.out.println((i+1)+". " + hotels[i].getHotelName());
        }
        int hotelNum =  scanner.nextInt();
        scanner.nextLine();
        hotelNum--;

        System.out.print("Search by: \n" + "1. Booking total price higher.\n" + "2. Booking total price lower.\n"
        + "3.Guest by Name.\n" + "4. Guest by Surname.\n" + "5. Guest by email.\n" + "6. Guest by phone.\n"
                + "7. Guest by id number.\n" + "8. Room price cheaper then.\n"
                + "9. Room more expensive then.\n" + "10. By room type.\n" + "11. Total price minimum.\n"
                + "12. Total price maximum.\n"+ "13. Room price minimum.\n"+ "14. Room price maximum.\n");

        String input = scanner.nextLine();

        Integer comparisonInt = 0;
        String comparisonString = "";

        switch (input) {
            case "1","2","8","9" -> {
                System.out.println("Enter comparison value: ");
                comparisonInt = scanner.nextInt();
                scanner.nextLine();
            }
            case "3","4","5","6","7","10" -> {
                System.out.println("Enter comparison value: ");
                comparisonString = scanner.nextLine();
            }
        }

        switch (input) {
            case "1" -> BookingService.byTotalPriceHigher(hotels[hotelNum],comparisonInt);
            case "2" -> BookingService.byTotalPriceLower(hotels[hotelNum],comparisonInt);
            case "3" -> GuestService.byName(hotels[hotelNum],comparisonString);
            case "4" -> GuestService.bySurname(hotels[hotelNum],comparisonString);
            case "5" -> GuestService.byEmail(hotels[hotelNum],comparisonString);
            case "6" -> GuestService.byPhoneNumber(hotels[hotelNum],comparisonString);
            case "7" -> GuestService.byIdNumber(hotels[hotelNum],comparisonString);
            case "8" -> RoomService.byRoomCheaperThen(hotels[hotelNum],comparisonInt);
            case "9" -> RoomService.byMoreExpensiveThen(hotels[hotelNum],comparisonInt);
            case "10" -> RoomService.byRoomType(hotels[hotelNum],comparisonString);
            case "11" -> BookingService.byTotalPriceMinimum(hotels[hotelNum]);
            case "12" -> BookingService.byTotalPriceMaximum(hotels[hotelNum]);
            case "13" -> RoomService.byRoomPriceMinimum(hotels[hotelNum]);
            case "14" -> RoomService.byRoomPriceMaximum(hotels[hotelNum]);
        }
    }
}
