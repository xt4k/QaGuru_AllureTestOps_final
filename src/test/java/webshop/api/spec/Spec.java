package webshop.api.spec;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static webshop.api.template.ReportTemplate.filteres;

public class Spec {

    @Step("Form Request")
    public static RequestSpecification requestForm() {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .baseUri(baseURI)
                .filter(filteres().customTemplates())
                .log().uri();
    }

    @Step("JSON Request")
    public static RequestSpecification requestJson() {
        return given()
                .contentType(JSON)
                .baseUri(baseURI)
                .filter(filteres().customTemplates())
                .log().uri();
    }

}
