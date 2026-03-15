package demo.bdd.locators;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class KeyboardActionsPage extends UIInteractions {

    public static final String PAGE_URL = "https://play1.automationcamp.ir/keyboard_events.html";

    public static final By KEYBOARD_AREA = By.id("area");

    public static final By KEY_DISPLAY = By.id("key");
    public static final By CODE_DISPLAY = By.id("code");

    public static final By META_INDICATOR = By.id("meta");
    public static final By CTRL_INDICATOR = By.id("ctrl");
    public static final By ALT_INDICATOR = By.id("alt");
    public static final By SHIFT_INDICATOR = By.id("shift");
}
