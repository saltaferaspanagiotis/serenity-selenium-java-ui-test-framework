package demo.bdd.actions;

import demo.bdd.locators.KeyboardActionsPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class KeyboardActionsUI extends PageObject {

    public void navigateToKeyboardActionsPage() {
        openAt(KeyboardActionsPage.PAGE_URL);
        Wait.forElementToBeClickable(getDriver(), $(KeyboardActionsPage.KEYBOARD_AREA));
    }

    public void typeCharacterInArea(String character) {
        $(KeyboardActionsPage.KEYBOARD_AREA).click();
        switch (character) {
            case "Control":
                character = Keys.CONTROL.toString();
                break;
            case "Alt":
                character = Keys.ALT.toString();
                break;
            case "Home":
                character = Keys.HOME.toString();
                break;
            case "ArrowDown":
                character = Keys.ARROW_DOWN.toString();
                break;
            case "PageUp":
                character = Keys.PAGE_UP.toString();
                break;
            default:
                throw new IllegalArgumentException("Unsupported character: " + character);
        }
        $(KeyboardActionsPage.KEYBOARD_AREA).sendKeys(character);
    }
}
