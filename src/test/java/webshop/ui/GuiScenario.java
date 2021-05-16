package webshop.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import po.BasePageObject;
import webshop.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.baseURI;

@Epic("Browser UI auto-tests")
@Feature("Web-shop")
@Story("Button `Search`")
@Owner("qa_guru")
@Tag("qa_guru_gui")
public class GuiScenario extends TestBase {

    @Step("Success scenario for test `Search` button.")
    void successSearchScenario(String query) {
        open(baseUrl);
        new BasePageObject().search(query)
                .checkSearchResult(query);
    }

    @Step("Scenario with `UnSuccess search`.")
    void unSuccessSearchScenario(String query, String message) {
        open(baseUrl);
        new BasePageObject().search(query)
                .checkNoSearchResult(message);
    }
}
