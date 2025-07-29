package com.testing.restassured;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestAssuredTodoTests {

    private static String TODOS_URL = "https://jsonplaceholder.typicode.com/todos/{id}";

    @Epic("Schema Validation")
    @Feature("Test API")
    @Story("Test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Schema Validation")
    @Test
    void testSchemaValidation() {

        RestAssured
                .given()
                .accept(ContentType.JSON)
                .pathParam("id", 1)
                .when()
                .get(TODOS_URL)
                .then()
                .body(matchesJsonSchemaInClasspath("todo_schema.json"));
    }
}
