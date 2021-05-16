package mobile;

import io.appium.java_client.MobileBy;
import io.qameta.allure.JiraIssue;
import io.qameta.allure.JiraIssues;
import io.qameta.allure.TM4J;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

@Tag("bs_android")
public class ExtSelenideAndroidTests extends TestBaseMob {

    @Test
    @Tag("bs_android")
    @DisplayName("Successful search in BS Sample App `Wikipedia android`.")
    @TM4J("XT-MAN-1")
    @JiraIssues({@JiraIssue("AUTO-201")})
    void searchTest() {
        step("Type search", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Selenide");
        });
        step("Check if any Application found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}