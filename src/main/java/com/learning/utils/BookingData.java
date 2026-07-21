package com.learning.utils;

import com.learning.models.Booking;
import com.learning.models.BookingDates;

//This class is used to create a booking object with predefined data. It can be used in tests to create a booking without having to manually input the data each time.
public class BookingData {
	
    public static Booking createBooking() {

        BookingDates dates =
                new BookingDates(
                        "2026-08-01",
                        "2026-08-10");

        return new Booking(
                "Mahesh",
                "Jadhav",
                1500,
                true,
                dates,
                "Breakfast");

    }

}