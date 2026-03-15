package demo.bdd.questions;

import demo.bdd.locators.AdvancedUIPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AdvancedUIQuestionsUI extends PageObject {

    public void verifyRatingValidationMessageShows(String expectedMessage) {
        Wait.forElementToBeDisplayed(getDriver(), $(AdvancedUIPage.RATING_VALIDATE));
        String actual = $(AdvancedUIPage.RATING_VALIDATE).getText().trim();
        Assertions.assertEquals(expectedMessage, actual);
    }
}
