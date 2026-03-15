package demo.bdd.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }
}
