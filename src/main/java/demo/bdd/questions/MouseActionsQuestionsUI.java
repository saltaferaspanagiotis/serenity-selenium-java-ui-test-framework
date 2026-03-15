package demo.bdd.questions;

import demo.bdd.locators.MouseActionsPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MouseActionsQuestionsUI extends PageObject {

    public void verifyClickTypeIs(String expectedType) {
        Wait.forElementToBeDisplayed(getDriver(), $(MouseActionsPage.CLICK_TYPE));
        String actual = $(MouseActionsPage.CLICK_TYPE).getText().trim();
        Assertions.assertEquals(expectedType, actual);
    }

    public void verifyClickTypeIsNot(String unexpectedType) {
        String actual = $(MouseActionsPage.CLICK_TYPE).getText().trim();
        Assertions.assertNotEquals(unexpectedType, actual);
    }

    public void verifySelectedLanguageIs(String expectedLanguage) {
        Wait.forElementToBeDisplayed(getDriver(), $(MouseActionsPage.HOVER_VALIDATE));
        String actual = $(MouseActionsPage.HOVER_VALIDATE).getText().trim();
        Assertions.assertEquals(expectedLanguage, actual);
    }

    public void verifySelectedLanguageIsNot(String unexpectedLanguage) {
        String actual = $(MouseActionsPage.HOVER_VALIDATE).getText().trim();
        Assertions.assertNotEquals(unexpectedLanguage, actual);
    }

    public void verifyDropSuccessMessageDisplayed() {
        Wait.forElementToBeDisplayed(getDriver(), $(MouseActionsPage.DROP_SUCCESS_TEXT));
        Assertions.assertTrue($(MouseActionsPage.DROP_SUCCESS_TEXT).isDisplayed());
    }
}
