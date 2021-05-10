package webshop.api;

import io.qameta.allure.Step;
import webshop.TestBase;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.HTML;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestScenario extends TestBase {

    @Step("Scenario for test `Search` button.")
    void searchScenario(String query, String returnText) {
        String body = given()
                .contentType(HTML)
                .params("Q", query)
                .when()
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        assertThat(body.contains(returnText));
    }
}
