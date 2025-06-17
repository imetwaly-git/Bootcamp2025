package com.polteq.tests.restAssured;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RestAssuredTests {

    String baseURi = "https://api.jolpi.ca/ergast/f1/";

    @Test
    public void validateGETCurrentLastResultExpect200() {
        given().baseUri(baseURi)
                 .when()
                 .get("2025/drivers.json")
                 .then()
                 .statusCode(200);
    }

    @Test
    public void checkGETCurrentLastResultReturnsExpectedDriverID() {
        String driverID = "max_verstappen";
        String yearRaced = "2023";

        JsonPath json = given().baseUri(baseURi)
                .pathParam("year", yearRaced)
                .pathParam("driver", driverID)
                .when()
                .get("{year}/drivers/{driver}/results.json")
                .then()
                .statusCode(200)
                .extract()
                .response().jsonPath();

        String firstDriverId = json.getString("MRData.RaceTable.driverId");

        assertThat(firstDriverId).isEqualToIgnoringCase(driverID);

    }
}
