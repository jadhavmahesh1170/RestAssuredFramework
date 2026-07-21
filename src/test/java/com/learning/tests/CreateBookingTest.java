package com.learning.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.learning.base.BaseTest;
import com.learning.models.Booking;
import com.learning.models.BookingResponse;
import com.learning.services.BookingService;
import com.learning.specifications.ResponseSpecificationBuilder;
import com.learning.utils.JsonUtil;
import com.learning.utils.RandomDataUtil;
import com.learning.utils.ResponseUtil;
import com.learning.utils.TestContext;

import io.restassured.response.Response;

public class CreateBookingTest extends BaseTest {

	@Test(priority = 0, description = "Verify that a booking can be created successfully")

	public void verifyBookingCreation() {

		Booking booking = JsonUtil.readJson("testdata/booking.json", Booking.class);

		booking.setFirstname(RandomDataUtil.getRandomFirstName());
		booking.setLastname(RandomDataUtil.getRandomLastName());

		BookingService bookingService = new BookingService();

		Response response = bookingService.createBooking(booking);

		// response.prettyPrint();

		BookingResponse bookingResponse = ResponseUtil.parse(response, BookingResponse.class);

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(response.getStatusCode(), 200, "Create Booking API failed");

		response.then().body(matchesJsonSchemaInClasspath("schemas/createbooking_response_schema.json"));

		softAssert.assertTrue(bookingResponse.getBookingid() > 0, "Booking ID should be generated");

		softAssert.assertTrue(response.getTime() < 3000, "Response time exceeded 3 seconds");

		TestContext.setBookingId(bookingResponse.getBookingid());

		softAssert.assertEquals(bookingResponse.getBooking().getFirstname(), booking.getFirstname(),
				"First name does not match");

		softAssert.assertEquals(bookingResponse.getBooking().getLastname(), booking.getLastname(),
				"Last name does not match");

		softAssert.assertEquals(bookingResponse.getBooking().getTotalprice(), booking.getTotalprice(),
				"Total price does not match");

		softAssert.assertEquals(bookingResponse.getBooking().isDepositpaid(), booking.isDepositpaid(),
				"Deposit paid does not match");

		softAssert.assertAll();

	}

	@Test(priority = 1, description = "Verify that a booking can be retrieved successfully", dependsOnMethods = "verifyBookingCreation")

	public void getBookingTest() {

		BookingService service =

				new BookingService();

		Response response =

				service.getBooking(TestContext.getBookingId());

		response.then()

				.spec(ResponseSpecificationBuilder.successResponse());
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(response.getStatusCode(), 200, "Get Booking API failed");

		response.then().body(matchesJsonSchemaInClasspath("schemas/getbooking_response_schema.json"));

		softAssert.assertTrue(response.getTime() < 3000, "Response time exceeded 3 seconds");

		softAssert.assertAll();

	}

}