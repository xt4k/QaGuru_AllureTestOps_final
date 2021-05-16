package webshop.api;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import webshop.TestBase;

import static java.lang.System.getProperty;

@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Api testet for button `Search`")
@Owner("yuriy")
@Tags({@Tag("api"), @Tag("smoke"),@Tag("api_search")})
public class SearchButtonTests extends TestBase {
    private String query;
    private String answer;
    private ApiScenario apiTest = new ApiScenario();

    @TM4J("XT-API-1")
    @Test
    @DisplayName("Test Api_01: Search returns 1 result match.")
    @Tag("api_testset")
    void searchSuccess1Result() {
        query = getProperty("query");
        answer = "Show details for Copy of Computing and Internet EX";
        apiTest.apiSearchScenario(query, answer);
    }

    @TM4J("XT-API-2")
    @Test
    @DisplayName("Test Api_02: Search not found any result matched defined criteria.")
    @Tag("api_testset")
    void searchNoResultTest() {
        query = getProperty("query2");
        answer = "No products were found that matched your criteria.";
        apiTest.apiSearchScenario(query, answer);
    }
}