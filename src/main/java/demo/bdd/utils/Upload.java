package demo.bdd.utils;

import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Upload {

    public static void setLocalFileDetectorIfGrid(WebDriver driver) {
        String environment = System.getProperty("environment", "");
        if (environment.contains("grid")) {
            WebDriver proxied = ((WebDriverFacade) driver).getProxiedDriver();
            if (proxied instanceof RemoteWebDriver remoteDriver) {
                remoteDriver.setFileDetector(new LocalFileDetector());
            }
        }
    }
}
