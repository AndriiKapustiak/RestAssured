package com.herokuapp.restffulbooking;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.herokuapp.restfulbooker.BaseTest;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBookingTest(){
        Response response = createBooking();
        response.print();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it is not");
        SoftAssert softAssert = new SoftAssert();

        String firstname = response.jsonPath().getString("booking.firstname");
        softAssert.assertEquals(firstname, "Andrii");

        String lastname = response.jsonPath().getString("booking.lastname");
        softAssert.assertEquals(lastname, "Kapustiak");

        int totalprice = response.jsonPath().getInt("booking.totalprice");
        softAssert.assertEquals(totalprice, 320);

        boolean depositpaid = response.jsonPath().getBoolean("booking.depositpaid");
        softAssert.assertEquals(depositpaid, false);

        String checkin = response.jsonPath().getString("booking.bookingdates.checkin");
        softAssert.assertEquals(checkin, "2022-08-27");

        String checkout = response.jsonPath().getString("booking.bookingdates.checkout");
        softAssert.assertEquals(checkout, "2022-08-30");

        String additionalneeds = response.jsonPath().getString("booking.additionalneeds");
        softAssert.assertEquals(additionalneeds, "drugs");

        softAssert.assertAll();

    }
}
