package demo.bdd.locators;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class AdvancedUIPage extends UIInteractions {

    public static final String PAGE_URL = "https://play1.automationcamp.ir/advanced.html";

    // Rating challenge input, check button, and result badge
    public static final By RATING_INPUT = By.id("txt_rating");
    public static final By CHECK_RATING_BTN = By.id("check_rating");
    public static final By RATING_VALIDATE = By.id("validate_rating");

    // Star-rating label whose CSS :after pseudo-element holds the asterisk-based rating
    public static final By STAR_RATING_LABEL = By.cssSelector("label.star-rating");
}
