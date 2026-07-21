package com.learning.utils;

public class TestContext {

    private static int bookingId;

    public static int getBookingId() {
        return bookingId;
    }

    public static void setBookingId(int bookingId) {
        TestContext.bookingId = bookingId;
    }
}