package com.testing.restassured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class RestAssuredUsersTests {

    private static final String USERS_URL = "https://reqres.in/api/users?page=1";

    @Test
    @Disabled
    void testBody() {

        RestAssured
                .get(USERS_URL)
                .then()
                .rootPath("data[0]")
                .body("id", equalTo(1))
                .body("first_name", equalTo("George"))
                .noRootPath()
                .body("data.first_name[1]", equalTo("Janet"))
                .body("data.last_name", hasItems("Holt", "Morris"));

        RestAssured
                .get(USERS_URL)
                .then()
                .body("data.email[0]",
                        response -> containsStringIgnoringCase(response.body().jsonPath().get("data.first_name[0]")));
    }
}
