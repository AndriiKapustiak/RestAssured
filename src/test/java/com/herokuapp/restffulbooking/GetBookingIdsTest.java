package com.herokuapp.restffulbooking;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingIdsTest {

    @Test
    public void getBookingIdsWithoutFiltersTest() {

        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.print();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it is not");

        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertFalse(bookingIds.isEmpty(), "List is empty,but it should not");
    }
}

