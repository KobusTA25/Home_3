package org.max.lesson3.home.accuweather;

import io.restassured.http.Method;
import org.junit.jupiter.api.Test;
import org.max.lesson3.seminar.accuweather.AccuweatherAbstractTest;

import static io.restassured.RestAssured.given;

public class GetFifteenDayTest extends AccuweatherAbstractTest {

    @Test
    void get_fifteen_day_return_401() {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 290396)
                .when()
                .request(Method.GET,getBaseUrl()+"/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);
    }
}
