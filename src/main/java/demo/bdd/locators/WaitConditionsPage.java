package demo.bdd.locators;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class WaitConditionsPage extends UIInteractions {

    public static final String PAGE_URL = "https://play1.automationcamp.ir/expected_conditions.html";

    public static final By MIN_WAIT = By.id("min_wait");
    public static final By MAX_WAIT = By.id("max_wait");

    public static final By ALERT_TRIGGER = By.id("alert_trigger");
    public static final By PROMPT_TRIGGER = By.id("prompt_trigger");
    public static final By CONFIRM_OK = By.id("confirm_ok");
    public static final By CONFIRM_CANCELLED = By.id("confirm_cancelled");
    public static final By ALERT_HANDLED = By.id("alert_handled");

    public static final By VISIBILITY_TRIGGER = By.id("visibility_trigger");
    public static final By VISIBILITY_TARGET = By.id("visibility_target");

    public static final By INVISIBILITY_TRIGGER = By.id("invisibility_trigger");
    public static final By INVISIBILITY_TARGET = By.id("invisibility_target");
    public static final By SPINNER_GONE = By.id("spinner_gone");

    public static final By ENABLED_TRIGGER = By.id("enabled_trigger");
    public static final By ENABLED_TARGET = By.id("enabled_target");

    public static final By PAGE_TITLE_TRIGGER = By.id("page_title_trigger");

    public static final By TEXT_VALUE_TRIGGER = By.id("text_value_trigger");
    public static final By WAIT_FOR_VALUE = By.id("wait_for_value");
    public static final By WAIT_FOR_TEXT = By.id("wait_for_text");

    public static final By FRAME_TRIGGER = By.id("wait_for_frame");
    public static final By FRAME_CONTAINER = By.id("frame");
}
