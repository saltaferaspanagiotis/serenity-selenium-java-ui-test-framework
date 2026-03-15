package demo.bdd.questions;

import demo.bdd.locators.KeyboardActionsPage;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class KeyboardActionsQuestionsUI extends PageObject {

    public void verifyDetectedKeyName(String expectedKey) {
        String actual = $(KeyboardActionsPage.KEY_DISPLAY).getText().trim();
        Assertions.assertEquals(expectedKey, actual);
    }

    public void verifyKeyDisplayIsEmpty() {
        String actual = $(KeyboardActionsPage.KEY_DISPLAY).getText().trim();
        Assertions.assertTrue(actual.isEmpty(), "Expected key display to be empty but was: " + actual);
    }
}
