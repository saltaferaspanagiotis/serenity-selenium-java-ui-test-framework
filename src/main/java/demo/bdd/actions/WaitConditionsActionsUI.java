package demo.bdd.actions;

import demo.bdd.locators.WaitConditionsPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class WaitConditionsActionsUI extends PageObject {

    public void navigateToWaitConditionsPage() {
        openAt(WaitConditionsPage.PAGE_URL);
        Wait.forElementToBeClickable(getDriver(), $(WaitConditionsPage.MIN_WAIT));
    }

    public void setMinWait(String min) {
        $(WaitConditionsPage.MIN_WAIT).clear();
        $(WaitConditionsPage.MIN_WAIT).type(min);
    }

    public void setMaxWait(String max) {
        $(WaitConditionsPage.MAX_WAIT).clear();
        $(WaitConditionsPage.MAX_WAIT).type(max);
    }

    public void clickAlertTrigger() {
        $(WaitConditionsPage.ALERT_TRIGGER).click();
        Wait.forAlertToBeShown(getDriver());
        getDriver().switchTo().alert().accept();
    }

    public void clickPromptTriggerAndAccept() {
        $(WaitConditionsPage.PROMPT_TRIGGER).click();
        Wait.forAlertToBeShown(getDriver());
        getDriver().switchTo().alert().accept();
    }

    public void clickPromptTriggerAndDismiss() {
        $(WaitConditionsPage.PROMPT_TRIGGER).click();
        Wait.forAlertToBeShown(getDriver());
        getDriver().switchTo().alert().dismiss();
    }

    public void clickVisibilityTrigger() {
        $(WaitConditionsPage.VISIBILITY_TRIGGER).click();
    }

    public void clickInvisibilityTrigger() {
        $(WaitConditionsPage.INVISIBILITY_TRIGGER).click();
    }

    public void clickEnabledTrigger() {
        $(WaitConditionsPage.ENABLED_TRIGGER).click();
    }

    public void clickPageTitleTrigger() {
        $(WaitConditionsPage.PAGE_TITLE_TRIGGER).click();
    }

    public void clickTextValueTrigger() {
        $(WaitConditionsPage.TEXT_VALUE_TRIGGER).click();
    }
}
