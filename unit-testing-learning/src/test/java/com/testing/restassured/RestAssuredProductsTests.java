package com.testing.restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.restassured.model.User;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredProductsTests {

    private static final String PRODUCT_ONE_URL = "https://fakestoreapi.com/products/1";
    private static final String PRODUCT_TWO_URL = "https://fakestoreapi.com/products/2";
    private static final String PRODUCT_FIVE_URL = "https://fakestoreapi.com/products/5";
    private static final String SINGLE_PRODUCTS_URL = "https://fakestoreapi.com/products/{id}";
    private static final String COMPONENT_PRODUCTS_URL = "https://fakestoreapi.com/{component}/{id}";
    private static final String STORE_CART_URL = "https://fakestoreapi.com/carts";
    private static final String STORE_USER_URL = "https://fakestoreapi.com/users/{id}";
    private static final String STORE_CATEGORIES_URL = "https://fakestoreapi.com/products/categories";

    @Test
    void testProducts() {

        RestAssured.get(PRODUCT_ONE_URL)
                .then()
                .statusCode(200)
                .body("id", equalTo(1));

        RestAssured.get(PRODUCT_TWO_URL)
                .then()
                .statusCode(200)
                .body("id", equalTo(2));

        RestAssured.get(PRODUCT_FIVE_URL)
                .then()
                .statusCode(200)
                .body("id", equalTo(5));
    }

    @Test
    void testProductsWithPathParams() {

        RestAssured.get(SINGLE_PRODUCTS_URL, 1)
                .then()
                .statusCode(200)
                .body("id", equalTo(1));

        RestAssured.get(SINGLE_PRODUCTS_URL, 2)
                .then()
                .statusCode(200)
                .body("id", equalTo(2));

        RestAssured.get(SINGLE_PRODUCTS_URL, 5)
                .then()
                .statusCode(200)
                .body("id", equalTo(5));
    }

    @Test
    void testComponentsWithPathParams() {

        RestAssured.get(COMPONENT_PRODUCTS_URL, "products", 1)
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

    @Test
    void testComponentsWithPathParamsBdd() {

        RestAssured
                .given()
                .pathParam("component", "products")
                .pathParam("id", 1)
                .when()
                .get(COMPONENT_PRODUCTS_URL)
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

    @Test
    void testComponentsWithRequestParamsBdd() {

        RestAssured
                .given()
                .param("userId", 1)
                .when()
                .get(STORE_CART_URL)
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("size()", equalTo(7));
    }

    @Test
    void testBodyAsString() {

        ResponseBody<?> responseBody = RestAssured
                .given()
                .pathParam("id", 1)
                .when()
                .get(STORE_USER_URL);

        var responseBodyString = responseBody.asString();

        assertThat(responseBodyString.contains("address"), equalTo(true));
        assertThat(responseBodyString.contains("id"), equalTo(true));
        assertThat(responseBodyString.contains("email"), equalTo(true));
    }

    @Test
    void testBodyUsingJsonPath() {

        ResponseBody<?> responseBody = RestAssured
                .given()
                .pathParam("id", 1)
                .when()
                .get(STORE_USER_URL);

        var jsonPath = responseBody.jsonPath();

        Map<String, ?> bodyJson = jsonPath.get();
        System.out.println(bodyJson);

        Map<String, ?> addressJson = jsonPath.get("address");
        System.out.println(addressJson);

        Map<String, ?> geolocationJson = jsonPath.get("address.geolocation");
        System.out.println(geolocationJson);
    }

    @Test
    void testBody() {

        ResponseBody<?> responseBody = RestAssured
                .given()
                .pathParam("id", 1)
                .when()
                .get(STORE_USER_URL);

        var jsonPath = responseBody.jsonPath();

        assertThat(jsonPath.get("email"), equalTo("john@gmail.com"));
        assertThat(jsonPath.get("name.firstname"), equalTo("john"));
        assertThat(jsonPath.get("name.lastname"), equalTo("doe"));
    }

    @Test
    void testBodyBdd() {

        RestAssured
                .given()
                .pathParam("id", 1)
                .when()
                .get(STORE_USER_URL)
                .then()
                .body("id", equalTo(1))
                .body(containsStringIgnoringCase("zipcode"))
                .body(allOf(containsString("name"), containsString("address")));
    }

    @Test
    void testBodyJsonBdd() {

        RestAssured
                .given()
                .pathParam("id", 1)
                .when()
                .get(STORE_USER_URL)
                .then()
                .body("address.city", equalTo("kilcoole"))
                .body("address.street", equalTo("new road"))
                .body("address.number", equalTo(7682))
                .rootPath("name")
                .body("firstname", equalTo("john"))
                .body("lastname", equalTo("doe"));
    }

    @Test
    @Disabled
    void testBodyJsonCategoriesBdd() {

        RestAssured
                .get(STORE_CATEGORIES_URL)
                .then()
                .body("$", hasItem("jewelery"))
                .body("$", hasItems("jewelery", "electronics"))
                .body("", contains("jewelery"));

        RestAssured
                .get(STORE_CATEGORIES_URL)
                .then()
                .body("[0]", notNullValue())
                .body("[2]", notNullValue());

        RestAssured
                .get(STORE_CATEGORIES_URL)
                .then()
                .body("[0].id", notNullValue())
                .body("[0].title", notNullValue());
    }

    @Test
    void testUserBody() throws JsonProcessingException {

        var response = RestAssured
                .given()
                .pathParam("id", 3)
                .when()
                .get(STORE_USER_URL)
                .then()
                .extract()
                .response();

        var objectMapper = new ObjectMapper();

        var user = objectMapper.readValue(response.asString(), User.class);

        assertThat(user.getId(), equalTo(3));
        assertThat(user.getEmail(), equalTo("kevin@gmail.com"));
        assertThat(user.getUsername(), equalTo("kevinryan"));
    }
}
