package webshop.api.client;

import io.restassured.response.Response;
import pojo.Form;
import webshop.api.spec.Spec;

import static java.lang.String.format;


public class SpecClient {
    public Response getSearch(String search) {
        return Spec.requestJson()
                .when()
                .params("Q", search)
                .get("/search")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();
    }

    public Response sendVirtualGiftCard(Form form) {
        return Spec.requestForm()
                .when()
                .formParam(format("giftcard_%s.RecipientName", form.getCardIndex()), form.getRecName())
                .formParam(format("giftcard_%s.RecipientEmail", form.getCardIndex()), form.getRecMail())
                .formParam(format("giftcard_%s.SenderEmail", form.getCardIndex()), form.getSendMail())
                .formParam(format("giftcard_%s.SenderName", form.getCardIndex()), form.getSendName())
                .formParam(format("giftcard_%s.Message", form.getCardIndex()), form.getMsg())
                .formParam(format("addtocart_%s.EnteredQuantity", form.getCardIndex()), form.getAddtocart())
                .post(form.getApiSuffix())
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();
    }

    public Response sendPhysicalGiftCard(Form form) {
        return Spec.requestForm()
                .when()
                .formParam(format("giftcard_%s.RecipientName", form.getCardIndex()), form.getRecName())
                .formParam(format("giftcard_%s.SenderName", form.getCardIndex()), form.getSendName())
                .formParam(format("giftcard_%s.Message", form.getCardIndex()), form.getMsg())
                .formParam(format("addtocart_%s.EnteredQuantity", form.getCardIndex()), form.getAddtocart())
                .post(form.getApiSuffix())
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();
    }
}
