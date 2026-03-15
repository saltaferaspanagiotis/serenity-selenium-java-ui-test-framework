package demo.bdd.locators;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class PopupWindowsPage extends UIInteractions {

    public static final String PAGE_URL = "https://play1.automationcamp.ir/multi_window.html";

    // Links that open new browser windows
    public static final By OPEN_WINDOW_1 = By.cssSelector("a[href='frame2.html']");
    public static final By OPEN_WINDOW_2 = By.cssSelector("a[href='frame4.html']");

    // Main page heading — used to verify the original window is active
    public static final By PAGE_HEADING = By.xpath("//a[text()='The Playground']");

    // Elements inside New Window 1 (frame2.html)
    public static final By WINDOW_1_BUTTON = By.id("click_me_2");

    // Elements inside New Window 2 (frame4.html)
    public static final By WINDOW_2_BUTTON = By.id("click_me_4");
}
