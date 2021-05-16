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
import static io.qameta.allure.Allure.step;


public class ExtSelenideIosTests extends TestBaseMob {

    @Test
    @Tag("iphone")
    @DisplayName("Successful iOS auto test `hello@browserstack.com`.")
    @TM4J("XT-MI-1")
    @JiraIssues({@JiraIssue("XT-MI-1")})
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Text Button")).click();
            $(MobileBy.AccessibilityId("Text Input")).sendKeys("hello@browserstack.com");
        });

        step("Check if any Application found", () -> {
            $$(MobileBy.AccessibilityId("Text Output")).shouldHave(sizeGreaterThan(0));
        });
    }
}