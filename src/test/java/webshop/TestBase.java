package webshop;

import config.WebConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.filters;
import static java.lang.System.getProperties;
import static java.lang.System.setProperty;

public class TestBase {

    @BeforeAll
    @DisplayName("Precondition step")
    static void setUp() {
        filters(new AllureRestAssured());

        //   baseUrl=baseURI;
        final WebConfig config = ConfigFactory.create(WebConfig.class, getProperties());
        browser = config.getBrowser();
        browserVersion = config.getBrowserVersion();
        startMaximized = true;
        baseUrl = config.getBaseUrl();
        baseURI = config.getBaseUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", config.isEnableVnc());
        capabilities.setCapability("enableVideo", config.isEnableVideo());
        browserCapabilities = capabilities;
        remote = config.getServer();

        addListener("AllureSelenide", new AllureSelenide());
     /*   browser = MobileDriver.class.getName();
        startMaximized = false;
        browser = MobileDriver.class.;
        *///browserSize = "1920x1080";

        timeout = 10000;


        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/common.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.forEach((key, value) -> setProperty((String) key, (String) value));


    }
}