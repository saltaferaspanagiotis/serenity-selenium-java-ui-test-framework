package demo.bdd.questions;

import demo.bdd.locators.PopupWindowsPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PopupWindowsQuestionsUI extends PageObject {

    public void verifyNewWindowButtonTextIs(String expectedText) {
        String currentUrl = getDriver().getCurrentUrl();
        assert currentUrl != null;
        if (currentUrl.contains("frame2.html")) {
            Wait.forElementToBeDisplayed(getDriver(), $(PopupWindowsPage.WINDOW_1_BUTTON));
            Assertions.assertEquals(expectedText, $(PopupWindowsPage.WINDOW_1_BUTTON).getText().trim());
        } else {
            Wait.forElementToBeDisplayed(getDriver(), $(PopupWindowsPage.WINDOW_2_BUTTON));
            Assertions.assertEquals(expectedText, $(PopupWindowsPage.WINDOW_2_BUTTON).getText().trim());
        }
    }

    public void verifyNewWindowButtonTextIsNot(String unexpectedText) {
        String currentUrl = getDriver().getCurrentUrl();
        assert currentUrl != null;
        if (currentUrl.contains("frame2.html")) {
            String actual = $(PopupWindowsPage.WINDOW_1_BUTTON).getText().trim();
            Assertions.assertNotEquals(unexpectedText, actual);
        } else {
            String actual = $(PopupWindowsPage.WINDOW_2_BUTTON).getText().trim();
            Assertions.assertNotEquals(unexpectedText, actual);
        }
    }

    public void verifyPopupWindowsPageIsDisplayed() {
        Wait.forElementToBeDisplayed(getDriver(), $(PopupWindowsPage.PAGE_HEADING));
        Assertions.assertTrue($(PopupWindowsPage.PAGE_HEADING).isDisplayed());
    }
}
