package com.learning.services;

import com.learning.client.ApiClient;
import com.learning.constants.EndPoints;
import com.learning.models.Booking;

import io.restassured.response.Response;

public class BookingService {

	private ApiClient client = new ApiClient();

	public Response createBooking(Booking booking) {

		return client.post(EndPoints.BOOKING, booking);
	}

	public Response getBooking(int id) {

		return client.get(

				EndPoints.BOOKING + "/" + id);

	}

	public Response updateBooking(int bookingId, Booking booking) {

		return client.put(

				EndPoints.BOOKING + "/" + bookingId,

				booking,

				TokenManager.getToken());

	}

	public Response deleteBooking(int bookingId) {

		return client.delete(

				EndPoints.BOOKING + "/" + bookingId,

				TokenManager.getToken());

	}

}