package com.learning.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learning.base.BaseTest;
import com.learning.models.Booking;
import com.learning.services.BookingService;
import com.learning.utils.BookingData;
import com.learning.utils.TestContext;

import io.restassured.response.Response;

public class CreateBookingTest extends BaseTest {

    @Test

    public void verifyBookingCreation(){

        Booking booking =
                BookingData.createBooking();

        BookingService service =
                new BookingService();

        Response response =
                service.createBooking(booking);

        response.prettyPrint();

        Assert.assertEquals(
                response.getStatusCode(),
                200);
        int bookingId =
        		response.jsonPath()
        		.getInt("bookingid");
               
        System.out.println("Booking Id: "+bookingId);
        
        TestContext.setBookingId(bookingId);
        
        
        response =
        		service.getBooking(
        		TestContext.getBookingId());

        		Assert.assertEquals(
        		response.getStatusCode(),
        		200);

        		Assert.assertEquals(
        		response.jsonPath().getString("firstname"),
        		"Mahesh");

    }

}