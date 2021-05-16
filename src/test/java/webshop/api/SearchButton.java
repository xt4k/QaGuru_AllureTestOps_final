package webshop.api;

import helpers.QueryConverter;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import webshop.TestBase;

@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Button `Search`")
@Owner("yuriy")
@Tags( {@Tag("api_testset"),@Tag("shop_api")})
public class SearchButton extends TestBase {
    QueryConverter qc = new QueryConverter();
    private String query;
    private String answer;
    private TestScenario apiTest = new TestScenario();

    @TM4J("XT-API-3")
    @Test
    @DisplayName("Test 01: Search returns 1 result match.")
    @Tag("search_api")
    void searchSuccess1Result() {
        query = qc.getQuery("query");
        answer = "Show details for Copy of Computing and Internet EX";
        apiTest.searchScenario(query, answer);
    }

    @TM4J("XT-API-4")
    @Test
    @DisplayName("Test 02: Search not found any result matched defined criteria.")
    @Tag("search_api")
    void searchNoResultTest() {
        query = qc.getQuery("query2");
        answer = "No products were found that matched your criteria.";
        apiTest.searchScenario(query, answer);
    }
}