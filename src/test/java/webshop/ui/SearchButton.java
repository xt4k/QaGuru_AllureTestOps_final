package webshop.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import webshop.TestBase;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static java.lang.System.getProperty;

@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Gui testset for button `Search`")
@Owner("yuriy")
@Tag("shop_gui")
public class SearchButton extends TestBase {
    private String query;
    private GuiScenario apiTest = new GuiScenario();

    @JiraIssues({@JiraIssue("XT-UI-1")})
    @TM4J("XT-UI-1")
    @Test
    @DisplayName("Test Ui_01: Search returns 1 result match.")
    @Tag("ui_testset")
    void searchSuccess1Result() {
        query = getProperty("query3");
        apiTest = new GuiScenario();
        apiTest.successSearchScenario(query);
    }

    @JiraIssues({@JiraIssue("XT-UI-2")})
    @TM4J("XT-UI-2")
    @Test
    @DisplayName("Test Ui_02: Search not found any result.")
    @Tag("ui_testset")
    void searchNoResultTest() {
        query = getProperty("query2");
        apiTest = new GuiScenario();
        String message = getProperty("no.search.result");
        apiTest.unSuccessSearchScenario(query, message);
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (System.getProperty("video_storage") != null)
            attachVideo();
        closeWebDriver();
    }


}