package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.WebConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Configuration.*;
import static io.qameta.allure.Allure.step;
import static java.lang.System.setProperty;

public class MobileDriver implements WebDriverProvider {
    WebDriver customDriver;

    public static URL getUrl(DesiredCapabilities dc) {
        try {
            return new URL(dc.getCapability("server").toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        capabilities.setCapability("server", config.getServer());
        capabilities.setCapability("app", config.getApp());
        capabilities.setCapability("browser", config.getBrowser());
        capabilities.setCapability("locale", config.getLocale());
        capabilities.setCapability("language", config.getLanguage());

        System.out.println("config" + config.toString());

        if (config.getServer().contains("browserstack")) {
            capabilities.setCapability("browserstack.user", config.getUser());
            capabilities.setCapability("browserstack.key", config.getKey());
            capabilities.setCapability("device", config.getDevice());
            capabilities.setCapability("os_version", config.getOsVer());
            capabilities.setCapability("project", config.getProject());
            capabilities.setCapability("build", config.getBuild());
            capabilities.setCapability("name", config.getTestName());
            capabilities.setCapability("browserstack.debug", config.getDebug());

            setProperty("bs.user", config.getUser());
            setProperty("bs.key", config.getKey());

            if (config.getDevice().contains("iPhone"))
                customDriver = new IOSDriver(getUrl(capabilities), capabilities);
            else
                customDriver = new AndroidDriver(getUrl(capabilities), capabilities);
        }
        else if (config.getDevice().equals("browser")) {

            browser = config.getBrowser();
            browserVersion = config.getBrowserVersion();
            startMaximized = true;
            baseUrl = config.getBaseUrl();
            //  DesiredCapabilities capabilities = new DesiredCapabilities( );
            capabilities.setCapability("enableVNC", config.isEnableVnc());
            capabilities.setCapability("enableVideo", config.isEnableVideo());
            browserCapabilities = capabilities;
            remote = config.getServer();
            //   customDriver = new RemoteWebDriver();

        }
        else {
            capabilities.setCapability("automationName", config.getAutoName());
            capabilities.setCapability("platformName", config.getPlatformName());
            capabilities.setCapability("deviceName", config.getDeviceName());
            capabilities.setCapability("version", config.getOsVer());
            capabilities.setCapability("appPackage", config.getAppPackage());
            capabilities.setCapability("appActivity", config.getAppActivity());

            // capabilities.setCapability("app", config.getAbsPath());
            customDriver = new AndroidDriver(getUrl(capabilities), capabilities);
        }
        step("capabilities " + capabilities);
        return customDriver;
    }


}
