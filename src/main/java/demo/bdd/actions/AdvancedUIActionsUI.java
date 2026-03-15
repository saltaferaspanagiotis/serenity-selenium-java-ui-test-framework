package demo.bdd.actions;

import demo.bdd.locators.AdvancedUIPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AdvancedUIActionsUI extends PageObject {

    public void navigateToAdvancedUIPage() {
        openAt(AdvancedUIPage.PAGE_URL);
        Wait.forElementToBeClickable(getDriver(), $(AdvancedUIPage.RATING_INPUT));
    }

    /**
     * Reads the book rating from the CSS :after pseudo-element on the star-rating label.
     * The page renders 1-5 asterisks via JavaScript into the pseudo-element content.
     * We retrieve it via JavascriptExecutor and store it in ScenarioContext.
     */
    public String extractBookRating() {
        Wait.forElementToBeDisplayed(getDriver(), $(AdvancedUIPage.STAR_RATING_LABEL));
        WebElement starLabel = $(AdvancedUIPage.STAR_RATING_LABEL);
        String content = (String) ((JavascriptExecutor) getDriver()).executeScript(
                "return window.getComputedStyle(arguments[0], ':after').getPropertyValue('content');",
                starLabel);
        // content is returned as a quoted string, e.g. '"*****"' — strip quotes and count asterisks
        assert content != null;
        return content.replace("\"", "").replace("'", "").trim();

    }

    public void enterRatingInInputField(String rating) {
        $(AdvancedUIPage.RATING_INPUT).clear();
        $(AdvancedUIPage.RATING_INPUT).type(rating);
    }

    public void clickCheckRatingButton() {
        $(AdvancedUIPage.CHECK_RATING_BTN).click();
    }
}
