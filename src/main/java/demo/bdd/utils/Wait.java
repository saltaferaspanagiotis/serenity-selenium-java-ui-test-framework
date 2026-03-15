package demo.bdd.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Wait {

    public static void browserWaitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void forPageToLoadResults(WebDriver webDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void forAlertToBeShown(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void forElementToBeDisplayed(WebDriver webDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void forEitherElementToBeDisplayed(WebDriver webDriver, WebElement element1, WebElement element2) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(element1), ExpectedConditions.visibilityOf(element2)));
    }

    public static void forAllElementsToBeDisplayed(WebDriver webDriver, List<WebElement> elementsCollection) {
        WebDriverWait wbw = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wbw.until(ExpectedConditions.visibilityOfAllElements(elementsCollection));
    }

    public static void forElementToNotBeDisplayed(WebDriver webDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void forElementToBeClickable(WebDriver webDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void forElementToBeSelected(WebDriver webDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void forElementToBeDisplayedTimeout(WebDriver webDriver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void forElementToNotBeDisplayedTimeout(WebDriver webDriver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void forElementToHaveSpecificValue(WebDriver webDriver, WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, value));
    }

    public static void forBrowserPageTitleToBe(WebDriver webDriver, String title) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void forNumberOfWindowsToBe(WebDriver webDriver, int numberOfWindows) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
    }
}
