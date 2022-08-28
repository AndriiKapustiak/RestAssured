package com.herokuapp.restffulbooking;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetSpecificBookingTest {

    @Test
    public void getSpecificBooking(){
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/10");
        response.print();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it is not");
        SoftAssert softAssert = new SoftAssert();

        String firstname = response.jsonPath().getString("firstname");
        softAssert.assertEquals(firstname, "Mark");

        String lastname = response.jsonPath().getString("lastname");
        softAssert.assertEquals(lastname, "Smith");

        int totalprice = response.jsonPath().getInt("totalprice");
        softAssert.assertEquals(totalprice, 214);

        boolean depositpaid = response.jsonPath().getBoolean("depositpaid");
        softAssert.assertEquals(depositpaid, false);

        String checkin = response.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(checkin, "2022-07-30");

        String checkout = response.jsonPath().getString("bookingdates.checkout");
        softAssert.assertEquals(checkout, "2022-08-21");

        softAssert.assertAll();
    }
}
