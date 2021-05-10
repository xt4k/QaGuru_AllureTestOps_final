package webshop;

import io.qameta.allure.restassured.AllureRestAssured;
import lombok.ConfigurationKeys;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.filters;
import static java.lang.System.setProperty;

public class TestBase {

    @BeforeAll
    @DisplayName("Precondition step")
    static void setUp() {
        baseURI = "http://demowebshop.tricentis.com";
        baseUrl=baseURI;
        filters(new AllureRestAssured());
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/common.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.forEach((key, value) -> setProperty((String) key, (String) value));
    }
}