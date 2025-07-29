package com.testing.restassured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredAuthenticationTests {

    private final String BASIC_AUTH_URL = "https://httpbin.org/basic-auth/{user}/{password}";

    @Test
    void testBasicAuthNoAuth() {

        RestAssured.given()
                .pathParam("user", "someuser")
                .pathParam("password", "somepassword")
                .when()
                .get(BASIC_AUTH_URL)
                .then()
                .statusCode(401);
    }

    @Test
    void testBasicAuthWithAuth() {

        RestAssured.given()
                .pathParam("user", "someuser")
                .pathParam("password", "somepassword")
                .auth()
                .basic("someuser", "somepassword")
                .when()
                .get(BASIC_AUTH_URL)
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .body("user", equalTo("someuser"));
    }

    @Test
    void testBasicAuthWithPreemptiveAuth() {

        RestAssured.given()
                .pathParam("user", "someuser")
                .pathParam("password", "somepassword")
                .auth()
                .preemptive()
                .basic("someuser", "somepassword")
                .when()
                .get(BASIC_AUTH_URL)
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .body("user", equalTo("someuser"));
    }
}
