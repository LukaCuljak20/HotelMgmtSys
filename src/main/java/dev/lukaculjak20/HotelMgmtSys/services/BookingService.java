package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.Booking;
import dev.lukaculjak20.HotelMgmtSys.entity.Hotel;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BookingService {
    public static Booking[] byTotalPriceHigher(Hotel hotel,int comp){
        Booking[] result = new Booking[hotel.getListOfBookings().length];
        int count =0;
        for(int i=0;i<hotel.getListOfBookings().length;i++){
            if (hotel.getListOfBookings()[i].getTotalPrice().compareTo(BigDecimal.valueOf(comp))>=0){
                result[count++]=hotel.getListOfBookings()[i];
                System.out.println(hotel.getListOfBookings()[i].getRoom().getRoomNumber()+" "+hotel.getListOfBookings()[i].getTotalPrice().setScale(2, RoundingMode.HALF_UP));
            }
        }
        return result;
    }
    public static Booking[] byTotalPriceLower(Hotel hotel,int comp){
        Booking[] result = new Booking[hotel.getListOfBookings().length];
        int count=0;
        for(int i=0;i<hotel.getListOfBookings().length;i++){
            if (hotel.getListOfBookings()[i].getTotalPrice().compareTo(BigDecimal.valueOf(comp))<=0){
                result[count++]=hotel.getListOfBookings()[i];
                System.out.println(hotel.getListOfBookings()[i].getRoom().getRoomNumber()+" "+hotel.getListOfBookings()[i].getTotalPrice().setScale(2, RoundingMode.HALF_UP));
            }
        }
        return result;
    }
    public static Booking byTotalPriceMinimum(Hotel hotel){
        Booking result = hotel.getListOfBookings()[0];
        for(int i=0;i<hotel.getListOfBookings().length;i++){
            if (hotel.getListOfBookings()[i].getTotalPrice().compareTo(result.getTotalPrice())<0){
                result=hotel.getListOfBookings()[i];
            }
        }
        System.out.println(result.getRoom().getRoomNumber()+" "+result.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
        return result;
    }
    public static Booking byTotalPriceMaximum(Hotel hotel){
        Booking result = hotel.getListOfBookings()[0];
        for(int i=0;i<hotel.getListOfBookings().length;i++){
            if (hotel.getListOfBookings()[i].getTotalPrice().compareTo(result.getTotalPrice())>0){
                result=hotel.getListOfBookings()[i];
            }
        }
        System.out.println(result.getRoom().getRoomNumber()+" "+result.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
        return result;
    }
}
