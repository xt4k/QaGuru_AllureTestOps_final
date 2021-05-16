package webshop.api;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pojo.Form;
import webshop.TestBase;

import java.util.Random;


@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Api testset for add Gift Cards to wishlist")
@Owner("yuriy")
@Tag("wish_api")
public class AddGiftCardsTest extends TestBase {

    private ApiScenario apiTest = new ApiScenario();

    @TM4J("XT-API-7")
    @Test
    @DisplayName("Test Api_01: Add Virtual gift card 5$.")
    @Tag("api_testset")
    void senVirtualGiftCard5Success() {
        int cardNums = 1 + new Random().nextInt(11);
        int index = 1;
        //GiftCard giftCard = new GiftCard();
        String suffix = "addproducttocart/details/1/2";
        Form form = new Form(cardNums, suffix);
        apiTest.apiVirtualGiftCardScenarioPositive(form);
    }

    @TM4J("XT-API-8")
    @Test
    @DisplayName("Test Api_02: Add Physical gift card 50$.")
    @Tags( {@Tag("api_testset"),@Tag("physical_card_api_test")})
    void senPhysicalGiftCard50Success() {
        int cardNums = 2 + new Random().nextInt(22);
        int index = 3;
        //GiftCard giftCard = new GiftCard();
        String suffix = "addproducttocart/details/3/2";
        Form form = new Form(cardNums, suffix);
        apiTest.apiPhysicalGiftCardScenarioPositive(form);
    }
}
