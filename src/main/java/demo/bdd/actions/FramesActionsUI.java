package demo.bdd.actions;

import demo.bdd.locators.FramesPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FramesActionsUI extends PageObject {

    public void navigateToFramesPage() {
        openAt(FramesPage.PAGE_URL);
        Wait.forElementToBeDisplayed(getDriver(), $(FramesPage.INNER_FRAME_1));
    }

    public void switchToFirstIframe(int index) {

        switch (index) {
            case 1:
                getDriver().switchTo().frame((WebElement) $(FramesPage.INNER_FRAME_1));
                break;
            case 2:
                getDriver().switchTo().frame((WebElement) $(FramesPage.INNER_FRAME_1));
                getDriver().switchTo().frame((WebElement) $(FramesPage.INNER_FRAME_2));
                break;
            case 4:
                getDriver().switchTo().frame((WebElement) $(FramesPage.INNER_FRAME_1));
                getDriver().switchTo().frame((WebElement) $(FramesPage.INNER_FRAME_3));
                getDriver().switchTo().frame((WebElement) $(FramesPage.INNER_FRAME_4));
                break;
            default:
                throw new IllegalArgumentException("Invalid frame index: " + index);
        }
    }

    public void clickButtonInsideFrame(int index) {
        $(FramesPage.getInnerButton(index)).click();
    }

    public void switchBackToMainDocument() {
        getDriver().switchTo().defaultContent();
    }
}
