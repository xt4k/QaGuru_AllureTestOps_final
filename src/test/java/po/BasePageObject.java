package po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static helpers.AttachmentsHelper.attachScreenshot;


public class BasePageObject {
    SelenideElement seTopSearchField = $("#small-searchterms");
    SelenideElement seSearchResult = $("h2 a");//.//h2/a
    SelenideElement seNoResult = $("div.search-results strong");

    @Step("Set query {query} to search field.")
    public BasePageObject search(String query) {
        seTopSearchField.setValue(query)
                .pressEnter();
        attachScreenshot("Page `after query`.");
        return this;
    }

    @Step("Check if found item accord to search query.")
    public void checkSearchResult(String query) {
        attachScreenshot("Compare item page.");
        seSearchResult.scrollTo().shouldHave(text(query));
    }

    @Step("Check if found item accord to search query.")
    public void checkNoSearchResult(String query) {
        attachScreenshot("Compare text on `no search result` page.");
        seNoResult.shouldHave(text(query));
    }
}