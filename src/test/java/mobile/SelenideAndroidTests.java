package mobile;

import com.codeborne.selenide.Configuration;
import drivers.MobileDriver;
import io.appium.java_client.MobileBy;
import io.qameta.allure.JiraIssue;
import io.qameta.allure.JiraIssues;
import io.qameta.allure.TM4J;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;

@Tag("android")
public class SelenideAndroidTests {

    @Test
    @TM4J("XT-MW-0")
    @JiraIssues({@JiraIssue("AUTO-201")})
    void searchTest() {
        Configuration.browser = MobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;

        open();
        $(AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Selenide App");
        $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container")).shouldHave(sizeGreaterThan(0));
    }
}
