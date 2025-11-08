package dev.lukaculjak20.HotelMgmtSys.services;

import dev.lukaculjak20.HotelMgmtSys.entity.Guest;
import dev.lukaculjak20.HotelMgmtSys.entity.Hotel;

public class GuestService {
    public static Guest[] byName(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getFirstName().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
    public static Guest[] bySurname(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getLastName().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
    public static Guest[] byEmail(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getEmail().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
    public static Guest[] byIdNumber(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getIdNumber().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
    public static Guest[] byPhoneNumber(Hotel hotel,String comp) {
        int n=0,count=0;
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            n+=hotel.getListOfBookings()[i].getGuest().length;
        }
        Guest[] result = new Guest[n];
        for (int i = 0; i < hotel.getListOfBookings().length; i++) {
            for (int j = 0; j < hotel.getListOfBookings()[i].getGuest().length; j++) {
                if(hotel.getListOfBookings()[i].getGuest()[j].getPhoneNumber().equalsIgnoreCase(comp)) {
                    result[count++]=hotel.getListOfBookings()[i].getGuest()[j];
                    System.out.println(hotel.getListOfBookings()[i].getGuest()[j].getEmail());
                }
            }
        }
        return result;
    }
}
