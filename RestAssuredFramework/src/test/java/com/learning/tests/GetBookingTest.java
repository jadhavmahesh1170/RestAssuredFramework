package com.learning.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.learning.base.BaseTest;
import com.learning.models.Booking;
import com.learning.services.BookingService;
import com.learning.specifications.ResponseSpecificationBuilder;
import com.learning.utils.ResponseUtil;
import com.learning.utils.TestContext;

import io.restassured.response.Response;

public class GetBookingTest extends BaseTest {

	@Test

	public void verifyBooking() {

		BookingService service =

				new BookingService();

		Response response =

				service.getBooking(TestContext.getBookingId());

		response.then()

				.spec(ResponseSpecificationBuilder.successResponse());

		response.then().body(matchesJsonSchemaInClasspath("schemas/getbooking_response_schema.json"));

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(response.getStatusCode(), 200);
		softAssert.assertAll();

	}

}