package demo.bdd.locators;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

/**
 * Locators for the Sample Pages login form (login.html).
 * Note: the username field ID is "user" (not "username") — confirmed from page inspection.
 */
public class SamplePagesLoginPage extends UIInteractions {

    public static final String PAGE_URL = "https://play1.automationcamp.ir/login.html";

    public static final By USERNAME_FIELD = By.id("user");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BTN = By.id("login");

    // Shown on failed login
    public static final By ERROR_MESSAGE = By.id("message");

    // Shown on the post-login page (order_submit.html)
    public static final By PIZZA_HOUSE_HEADING = By.tagName("h3");
}
