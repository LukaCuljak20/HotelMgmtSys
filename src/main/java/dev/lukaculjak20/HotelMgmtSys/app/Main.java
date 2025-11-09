package dev.lukaculjak20.HotelMgmtSys.app;

import ch.qos.logback.classic.Logger;
import dev.lukaculjak20.HotelMgmtSys.services.*;
import dev.lukaculjak20.HotelMgmtSys.entity.*;
import org.slf4j.LoggerFactory;


import java.awt.print.Book;
import java.util.List;
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

    List<Hotel> hotels = inputService.hotelDataEntry();

        System.out.println("Choose hotel: ");
        Integer hNum=1;
        for (Hotel hotel : hotels) {

            System.out.println(hNum+". "+hotel.getHotelName());
            hNum++;
        }
        int hotelNum =  scanner.nextInt();
        scanner.nextLine();
        hotelNum--;
        boolean running = true;
        while(running) {
            System.out.print("Search by: \n" + "1. Booking total price higher.\n" + "2. Booking total price lower.\n"
                    + "3.Guest by Name.\n" + "4. Guest by Surname.\n" + "5. Guest by email.\n" + "6. Guest by phone.\n"
                    + "7. Guest by id number.\n" + "8. Room price cheaper then.\n"
                    + "9. Room more expensive then.\n" + "10. By room type.\n" + "11. Total price minimum.\n"
                    + "12. Total price maximum.\n" + "13. Room price minimum.\n" + "14. Room price maximum.\n"
                    +"15. Sorted by total price\n"+"16. Sorted by total price in reverse order\n" +"17. EXIT\n");

            String input = scanner.nextLine();

            Integer comparisonInt = 0;
            String comparisonString = "";

            switch (input) {
                case "1", "2", "8", "9" -> {
                    System.out.println("Enter comparison value: ");
                    comparisonInt = scanner.nextInt();
                    scanner.nextLine();
                }
                case "3", "4", "5", "6", "7", "10" -> {
                    System.out.println("Enter comparison value: ");
                    comparisonString = scanner.nextLine();
                }
            }


            switch (input) {
                case "1" ->
                        BookingService.print(BookingService.byTotalPriceHigher(hotels.get(hotelNum), comparisonInt));
                case "2" -> BookingService.print(BookingService.byTotalPriceLower(hotels.get(hotelNum), comparisonInt));
                case "3" -> GuestService.print(GuestService.byName(hotels.get(hotelNum), comparisonString));
                case "4" -> GuestService.print(GuestService.bySurname(hotels.get(hotelNum), comparisonString));
                case "5" -> GuestService.print(GuestService.byEmail(hotels.get(hotelNum), comparisonString));
                case "6" -> GuestService.print(GuestService.byPhoneNumber(hotels.get(hotelNum), comparisonString));
                case "7" -> GuestService.print(GuestService.byIdNumber(hotels.get(hotelNum), comparisonString));
                case "8" -> RoomService.print(RoomService.byRoomCheaperThen(hotels.get(hotelNum), comparisonInt));
                case "9" -> RoomService.print(RoomService.byMoreExpensiveThen(hotels.get(hotelNum), comparisonInt));
                case "10" -> RoomService.print(RoomService.byRoomType(hotels.get(hotelNum), comparisonString));
                case "11" -> BookingService.print(BookingService.byTotalPriceMinimum(hotels.get(hotelNum)));
                case "12" -> BookingService.print(BookingService.byTotalPriceMaximum(hotels.get(hotelNum)));
                case "13" -> RoomService.print(RoomService.byRoomPriceMinimum(hotels.get(hotelNum)));
                case "14" -> RoomService.print(RoomService.byRoomPriceMaximum(hotels.get(hotelNum)));
                case "15" -> BookingService.print(BookingService.sortedByTotalPrice(hotels.get(hotelNum)));
                case "16" -> BookingService.print(BookingService.sortedByTotalPriceReversed(hotels.get(hotelNum)));
                case "17" -> running = false;
            }
        }
    }
}
