package demo.bdd.questions;

import demo.bdd.locators.SamplePagesLoginPage;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SamplePagesQuestionsUI extends PageObject {

    public void verifyRedirectedToPizzaHousePage(String expectedTitle) {
        Wait.forElementToBeDisplayed(getDriver(), $(SamplePagesLoginPage.PIZZA_HOUSE_HEADING));
        Assertions.assertEquals(expectedTitle, $(SamplePagesLoginPage.PIZZA_HOUSE_HEADING).getText());
    }

    public void verifyLoginErrorMessageDisplayed() {
        Assertions.assertTrue($(SamplePagesLoginPage.ERROR_MESSAGE).isDisplayed());
    }
}
