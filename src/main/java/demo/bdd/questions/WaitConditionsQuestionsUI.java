package demo.bdd.questions;

import demo.bdd.locators.WaitConditionsPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class WaitConditionsQuestionsUI extends PageObject {

    public void verifyAlertHandledMessageDisplayed() {
        Wait.forElementToBeDisplayed(getDriver(), $(WaitConditionsPage.ALERT_HANDLED));
        Assertions.assertTrue($(WaitConditionsPage.ALERT_HANDLED).isDisplayed());
    }

    public void verifyConfirmOKMessageDisplayed() {
        Wait.forElementToBeDisplayed(getDriver(), $(WaitConditionsPage.CONFIRM_OK));
        Assertions.assertTrue($(WaitConditionsPage.CONFIRM_OK).isDisplayed());
    }

    public void verifyConfirmCancelledMessageDisplayed() {
        Wait.forElementToBeDisplayed(getDriver(), $(WaitConditionsPage.CONFIRM_CANCELLED));
        Assertions.assertTrue($(WaitConditionsPage.CONFIRM_CANCELLED).isDisplayed());
    }

    public void verifyVisibilityTargetDisplayed() {
        Wait.forElementToBeDisplayed(getDriver(), $(WaitConditionsPage.VISIBILITY_TARGET));
        Assertions.assertTrue($(WaitConditionsPage.VISIBILITY_TARGET).isDisplayed());
    }

    public void verifyVisibilityTargetNotDisplayed() {
        Assertions.assertFalse($(WaitConditionsPage.VISIBILITY_TARGET).isCurrentlyVisible());
    }

    public void verifySpinnerDisplayed() {
        Assertions.assertTrue($(WaitConditionsPage.INVISIBILITY_TARGET).isDisplayed());
    }

    public void verifySpinnerNotDisplayed() {
        Wait.forElementToNotBeDisplayed(getDriver(), $(WaitConditionsPage.INVISIBILITY_TARGET));
        Assertions.assertFalse($(WaitConditionsPage.INVISIBILITY_TARGET).isCurrentlyVisible());
    }

    public void verifySpinnerGoneMessageDisplayed() {
        Wait.forElementToBeDisplayed(getDriver(), $(WaitConditionsPage.SPINNER_GONE));
        Assertions.assertTrue($(WaitConditionsPage.SPINNER_GONE).isDisplayed());
    }

    public void verifyEnabledTargetIsEnabled() {
        Wait.forElementToBeClickable(getDriver(), $(WaitConditionsPage.ENABLED_TARGET));
        Assertions.assertTrue($(WaitConditionsPage.ENABLED_TARGET).isEnabled());
    }

    public void verifyBrowserPageTitle(String expectedTitle) {
        Wait.forBrowserPageTitleToBe(getDriver(), expectedTitle);
        Assertions.assertEquals(expectedTitle, getDriver().getTitle());
    }

    public void verifyTextInputContains(String expectedText) {
        Wait.forElementToHaveSpecificValue(getDriver(), $(WaitConditionsPage.WAIT_FOR_VALUE), expectedText);
        Assertions.assertEquals(expectedText, $(WaitConditionsPage.WAIT_FOR_VALUE).getValue());
    }

    public void verifyButtonTextShows(String expectedText) {
        Assertions.assertEquals(expectedText, $(WaitConditionsPage.WAIT_FOR_TEXT).getText().trim());
    }
}
