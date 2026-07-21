package com.learning.utils;

import com.learning.models.Booking;

public class BookingResponse {
	
	private int bookingid;

    private Booking booking;

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
