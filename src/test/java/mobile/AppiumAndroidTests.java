package mobile;

import io.appium.java_client.MobileBy;
import io.qameta.allure.TM4J;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachmentsHelper.attachPageSource;
import static helpers.AttachmentsHelper.attachScreenshot;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class AppiumAndroidTests extends TestBaseMob {

    @Test
    @Tag("emu_android")
    @DisplayName("Successful search in for Appium Android Emulator `Wikipedia`.")
    @TM4J("XT-MAP-1")
    void searchTest() {
        back();
        step("Type search", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Docker");
        });
        step("Check if any Application found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        closeWebDriver();
    }
}