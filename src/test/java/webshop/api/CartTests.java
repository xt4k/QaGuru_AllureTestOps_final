package webshop.api;

import helpers.Auth;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import webshop.TestBase;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Epic("Rest Assured")
@Feature("Web-shop")
@Story("Add item to `Cart`.")
@Owner("qa_guru")
@Tag("qa_guru_api")
public class CartTests extends TestBase {

    @JiraIssues({@JiraIssue("AUTO-199")})
    @TM4J("XT-API-5")
    @Test
    @Tag("api_testset")
    @DisplayName("Test Api-05")
    void addItemToCartWithHardCodeTest() {
        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookie("ARRAffinity=1fa9158750fcf7cee1728ac683a12594fe016bf3b1c0544237f51a4ffe2ef5ea; __utmc=78382081; __utmz=78382081.1616511077.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __RequestVerificationToken=1Ggj4MH1zaXe6_bAGo8oioIroK05NOUaOe14WhljCzw4J1QQJ534oqE_akH8FJqEeeP0Zd2Jpg9Wkcx1HkpBplq5dQnk7l9apiSN0CDLjPU1; ASP.NET_SessionId=1aj4jddt2se0pfra3vzngk4f; __utma=78382081.1412259254.1616511077.1616511077.1616515719.2; Nop.customer=9345ab71-54a6-468e-a89a-20fd34d3cc66; __utmt=1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=16&RecentlyViewedProductIds=52&RecentlyViewedProductIds=72; __atuvc=8%7C12; __atuvs=605a25f95ad95eba006; __utmb=78382081.30.10.1616515719")
                        .body("product_attribute_16_5_4=14&product_attribute_16_6_5=15&product_attribute_16_3_6=18&product_attribute_16_4_7=44&product_attribute_16_8_8=22&addtocart_16.EnteredQuantity=1")
                        .when()
                        .post("/addproducttocart/details/16/1")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .body("success", is(true))
                        .extract().response();

        System.out.println(response);
    }

    @JiraIssues({@JiraIssue("AUTO-199")})
    @TM4J("XT-API-6")
    @Test
    @Tag("api_testset")
    @DisplayName("Test Api 06")
    void addItemToCartWithCookieTest() {
        Map<String, String> cookies = new Auth().login("e@ma.il", "123456789");

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookies(cookies)
                        .body("product_attribute_16_5_4=14&product_attribute_16_6_5=15&product_attribute_16_3_6=18&product_attribute_16_4_7=44&product_attribute_16_8_8=22&addtocart_16.EnteredQuantity=1")
                        .when()
                        .post("/addproducttocart/details/16/1")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .body("success", is(true))
                        .extract().response();

        System.out.println(response);
    }
}
