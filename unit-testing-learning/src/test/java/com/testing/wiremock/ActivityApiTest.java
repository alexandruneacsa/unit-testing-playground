package com.testing.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class ActivityApiTest {

    WireMockServer wireMockServer;

    @BeforeSuite
    public void setup() {

        wireMockServer = new WireMockServer(9090);
        wireMockServer.start();

        RestAssured.baseURI = "http://localhost:9090";
        RestAssured.basePath = "activity";

        configureStubs();
    }

    @AfterSuite
    public void cleanup() {

        wireMockServer.stop();
    }

    void configureStubs() {

        var responseBody = "";

        wireMockServer.stubFor(get(urlEqualTo("/activity")).willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(responseBody)));
    }

    @Test
    void getActivityDetails() {

        RestAssured.given().when().get().then().statusCode(200).header("Content-Type", "application/json").log().body();
    }
}
