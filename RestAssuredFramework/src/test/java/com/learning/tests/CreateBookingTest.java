package com.learning.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.learning.base.BaseTest;
import com.learning.models.Booking;
import com.learning.services.BookingService;
import com.learning.utils.BookingResponse;
import com.learning.utils.JsonUtil;
import com.learning.utils.RandomDataUtil;
import com.learning.utils.ResponseUtil;
import com.learning.utils.TestContext;

import io.restassured.response.Response;

public class CreateBookingTest extends BaseTest {

    @Test

    public void verifyBookingCreation(){

        Booking booking = JsonUtil.readJson("testdata/booking.json", Booking.class);
        
        booking.setFirstname(RandomDataUtil.getRandomFirstName());
        booking.setLastname(RandomDataUtil.getRandomLastName());
            

        BookingService service =
                new BookingService();

        Response response =
                service.createBooking(booking);

        response.prettyPrint();
        
        response.then().body(matchesJsonSchemaInClasspath("schemas/createbooking_response_schema.json"));
        
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
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
        
        response.then().body(matchesJsonSchemaInClasspath("schemas/getbooking_response_schema.json"));

        softAssert.assertEquals(
        		response.getStatusCode(),
        		200);

        softAssert.assertEquals(
        		response.jsonPath().getString("firstname"),
        		booking.getFirstname());
        		
        Booking bookingResponse = ResponseUtil.parse(response, Booking.class);
        softAssert.assertEquals(bookingResponse.getFirstname(), booking.getFirstname());
                   
        softAssert.assertAll();
        
    }

}