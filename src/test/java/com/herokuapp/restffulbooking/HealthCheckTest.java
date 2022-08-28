package com.herokuapp.restffulbooking;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class HealthCheckTest {

    @Test
    public void healthCheckTest() {
                given()
                .when()
                .get("https://restful-booker.herokuapp.com/ping")
                .then()
                .assertThat()
                .statusCode(201);

    }
}
