package demo.bdd.questions;

import demo.bdd.locators.FramesPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FramesQuestionsUI extends PageObject {

    public void verifyInnerButtonTextIs(String expectedText, int frameIndex) {
        Wait.forElementToBeDisplayed(getDriver(), $(FramesPage.getInnerButton(frameIndex)));
        Assertions.assertEquals(expectedText, $(FramesPage.getInnerButton(frameIndex)).getText().trim());
    }

    public void verifyFramesPageHeadingIsDisplayed(boolean isDisplayed) {
        Assertions.assertEquals(isDisplayed, $(FramesPage.PAGE_HEADING).isVisible());
    }

}
