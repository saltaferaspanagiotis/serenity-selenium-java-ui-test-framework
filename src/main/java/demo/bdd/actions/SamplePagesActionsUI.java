package demo.bdd.actions;

import demo.bdd.locators.SamplePagesLoginPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SamplePagesActionsUI extends PageObject {

    public void navigateToLoginPage() {
        openAt(SamplePagesLoginPage.PAGE_URL);
        Wait.forElementToBeClickable(getDriver(), $(SamplePagesLoginPage.USERNAME_FIELD));
    }

    public void enterUsername(String username) {
        $(SamplePagesLoginPage.USERNAME_FIELD).clear();
        $(SamplePagesLoginPage.USERNAME_FIELD).type(username);
    }

    public void enterPassword(String password) {
        $(SamplePagesLoginPage.PASSWORD_FIELD).clear();
        $(SamplePagesLoginPage.PASSWORD_FIELD).type(password);
    }

    public void clickLoginButton() {
        Wait.forElementToBeClickable(getDriver(), $(SamplePagesLoginPage.LOGIN_BTN));
        $(SamplePagesLoginPage.LOGIN_BTN).click();
    }

    public void quitBrowser() {
        getDriver().quit();
    }
}
