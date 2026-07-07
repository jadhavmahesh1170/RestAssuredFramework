package com.learning.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learning.base.BaseTest;
import com.learning.services.BookingService;
import com.learning.specifications.ResponseSpecificationBuilder;

import io.restassured.response.Response;

public class GetBookingTest extends BaseTest {

	@Test

	public void verifyBooking() {

		BookingService service =

				new BookingService();

		Response response =

				service.getBooking(2);

		response.then()

				.spec(ResponseSpecificationBuilder.successResponse());

		Assert.assertEquals(

				response.getStatusCode(),

				200);

	}

}