package demo.bdd.actions;

import demo.bdd.locators.MouseActionsPage;
import demo.bdd.utils.Element;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Scope("prototype")
public class MouseActionsUI extends PageObject {

    public void navigateToMouseActionsPage() {
        openAt(MouseActionsPage.PAGE_URL);
        Wait.forElementToBeClickable(getDriver(), $(MouseActionsPage.CLICK_AREA));
    }

    public void singleClickOnClickArea() {
        $(MouseActionsPage.CLICK_AREA).click();
    }

    public void doubleClickOnClickArea() {
        new Actions(getDriver())
                .doubleClick($(MouseActionsPage.CLICK_AREA))
                .perform();
    }

    public void rightClickOnClickArea() {
        new Actions(getDriver())
                .contextClick($(MouseActionsPage.CLICK_AREA))
                .perform();
    }

    public void hoverOverDropdownButton() {
        new Actions(getDriver())
                .moveToElement($(MouseActionsPage.DROPDOWN_BTN))
                .perform();
    }

    public void selectFromLanguageDropdown(String language) {
        By optionLocator;
        switch (language) {
            case "Java":
                optionLocator = MouseActionsPage.DD_JAVA;
                break;
            case "Python":
                optionLocator = MouseActionsPage.DD_PYTHON;
                break;
            case "JavaScript":
                optionLocator = MouseActionsPage.DD_JAVASCRIPT;
                break;
            default:
                throw new IllegalArgumentException("Unknown language option: " + language);
        }
        $(optionLocator).click();
    }

    public void dragDraggableElementToDropZone() {
        Element.scrollIntoView(getDriver(), $(MouseActionsPage.DRAGGABLE_ELEMENT));
        Wait.browserWaitFor(1000);
        new Actions(getDriver())
                .clickAndHold($(MouseActionsPage.DRAGGABLE_ELEMENT))
                .pause(Duration.ofMillis(500))
                .moveToElement($(MouseActionsPage.DROP_ZONE),5,5)
                .pause(Duration.ofMillis(500))
                .release()
                .perform();
    }
}
