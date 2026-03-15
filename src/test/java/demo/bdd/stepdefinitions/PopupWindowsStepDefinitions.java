package demo.bdd.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PopupWindowsStepDefinitions extends ConfigStepDefinitions {

    @Given("the user navigates to the Popup Windows page")
    public void theUserNavigatesToThePopupWindowsPage() {
        scenarioContext.setOriginalWindowHandle(popupWindowsActionsUI.navigateToPopupWindowsPage());
    }

    @When("the user opens {string}")
    public void theUserOpens(String windowName) {
        scenarioContext.setNewWindowHandle(popupWindowsActionsUI.openWindow(windowName, scenarioContext.getOriginalWindowHandle()));
    }

    @And("the user switches to the new browser window")
    public void theUserSwitchesToTheNewBrowserWindow() {
        popupWindowsActionsUI.switchToNewWindow(scenarioContext.getNewWindowHandle());
    }

    @And("the user clicks the button in the new window")
    public void theUserClicksTheButtonInTheNewWindow() {
        popupWindowsActionsUI.clickButtonInNewWindow();
    }

    @And("the user switches back to the original window")
    public void theUserSwitchesBackToTheOriginalWindow() {
        popupWindowsActionsUI.switchBackToOriginalWindow(scenarioContext.getOriginalWindowHandle());
    }

    @Then("the button text in the new window is {string}")
    public void theButtonTextInTheNewWindowIs(String expectedText) {
        popupWindowsQuestionsUI.verifyNewWindowButtonTextIs(expectedText);
    }

    @Then("the button text in the new window is not {string}")
    public void theButtonTextInTheNewWindowIsNot(String unexpectedText) {
        popupWindowsQuestionsUI.verifyNewWindowButtonTextIsNot(unexpectedText);
    }

    @Then("the Popup Windows page is displayed")
    public void thePopupWindowsPageIsDisplayed() {
        popupWindowsQuestionsUI.verifyPopupWindowsPageIsDisplayed();
    }
}
