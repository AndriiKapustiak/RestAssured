package com.herokuapp.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONObject;

public class BaseTest {

    protected Response createBooking() {

        JSONObject body = new JSONObject();
        body.put("firstname", "Andrii");
        body.put("lastname", "Kapustiak");
        body.put("totalprice", 320);
        body.put("depositpaid", false);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2022-08-27");
        bookingdates.put("checkout", "2022-08-30");

        body.put("additionalneeds", "drugs");
        body.put("bookingdates", bookingdates);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/booking");
        return response;
    }
}
