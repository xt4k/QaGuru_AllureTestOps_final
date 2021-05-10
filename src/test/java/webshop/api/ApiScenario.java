package webshop.api;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import pojo.Form;
import webshop.TestBase;
import webshop.api.client.SpecClient;

import java.util.Collections;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiScenario extends TestBase {
    private static SpecClient client;


    @BeforeAll()
    @DisplayName("API tests fixture")
    void fixture() {
        RestAssured.filters(Collections.singletonList(new AllureRestAssured()));
    }

    @Step("Scenario for test `Search` button.")
    void apiSearchScenario(String query, String returnText) {
        client = new SpecClient();
        String returnedText = client.getSearch(query).asString();
        step("text back: " + returnedText);
        //     assertThat(response.asString().contains(returnText));
    }

    @Step("Test Scenario for Virtual Gift Cards.")
    void apiVirtualGiftCardScenarioPositive(Form form) {
        client = new SpecClient();
        Response response = client.sendVirtualGiftCard(form);
        checkResponse(form, response);
    }

    @Step("Test scenario for Physical Gift Cards.")
    void apiPhysicalGiftCardScenarioPositive(Form form) {
        client = new SpecClient();
        Response response = client.sendPhysicalGiftCard(form);
        checkResponse(form, response);
    }

    @Step("Response fields verification.")
    private void checkResponse(Form form, Response response) {
        assertThat("Status", response.getBody().jsonPath().get("success").equals(true));
        assertThat("Message Start", response.asString().contains("The product has been added to your"));
        assertThat("Message End", response.asString().contains("wishlist"));
        assertThat("Card NUmbers", response.getBody().jsonPath().get("updatetopwishlistsectionhtml").equals("(" + form.getAddtocart() + ")"));
    }

}
