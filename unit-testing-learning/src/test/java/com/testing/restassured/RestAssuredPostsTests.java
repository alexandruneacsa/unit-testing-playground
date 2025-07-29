package com.testing.restassured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class RestAssuredPostsTests {

    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String PRODUCT_ONE_URL = "https://fakestoreapi.com/products/1";

    @Test
    void validateHeadersFirstTest() {

        RestAssured.get(POSTS_URL)
                .then()
                .statusCode(200)
                .time(lessThan(5L), TimeUnit.SECONDS)
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .header("Connection", equalTo("keep-alive"))
                .header("Etag", notNullValue())
                .header("Cache-Control", containsStringIgnoringCase("max-age=43200"))
                .header("Expires", equalTo("-1"))
                .header("X-Ratelimit-Limit", equalTo("1000"));
    }

    @Test
    void validateHeadersSecondTest() {

        RestAssured.get(POSTS_URL)
                .then()
                .header("Date", (dateString) -> LocalDate.parse(dateString, DateTimeFormatter.RFC_1123_DATE_TIME),
                        equalTo(LocalDate.now()));
    }

    @Test
    void validateHeadersThirdTest() {

        RestAssured.get(POSTS_URL)
                .then()
                .header("Expires", Integer::parseInt, equalTo(-1));
    }
}
