package demo.bdd.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WaitConditionsStepDefinitions extends ConfigStepDefinitions {

    @Given("the user navigates to the Wait Conditions page")
    public void theUserNavigatesToTheWaitConditionsPage() {
        waitConditionsActionsUI.navigateToWaitConditionsPage();
    }

    @When("the user sets minimum wait to {string} and maximum wait to {string}")
    public void theUserSetsMinimumWaitAndMaximumWait(String min, String max) {
        waitConditionsActionsUI.setMinWait(min);
        waitConditionsActionsUI.setMaxWait(max);
    }

    @When("the user clicks the Show Alert trigger")
    public void theUserClicksTheShowAlertTrigger() {
        waitConditionsActionsUI.clickAlertTrigger();
    }

    @When("the user clicks the Show Prompt trigger and accepts the dialog")
    public void theUserClicksTheShowPromptTriggerAndAcceptsTheDialog() {
        waitConditionsActionsUI.clickPromptTriggerAndAccept();
    }

    @When("the user clicks the Show Prompt trigger and dismisses the dialog")
    public void theUserClicksTheShowPromptTriggerAndDismissesTheDialog() {
        waitConditionsActionsUI.clickPromptTriggerAndDismiss();
    }

    @When("the user clicks the visibility trigger button")
    public void theUserClicksTheVisibilityTriggerButton() {
        waitConditionsActionsUI.clickVisibilityTrigger();
    }

    @When("the user clicks the invisibility trigger button")
    public void theUserClicksTheInvisibilityTriggerButton() {
        waitConditionsActionsUI.clickInvisibilityTrigger();
    }

    @When("the user clicks the enabled trigger button")
    public void theUserClicksTheEnabledTriggerButton() {
        waitConditionsActionsUI.clickEnabledTrigger();
    }

    @When("the user clicks the page title trigger button")
    public void theUserClicksThePageTitleTriggerButton() {
        waitConditionsActionsUI.clickPageTitleTrigger();
    }

    @When("the user clicks the text value trigger button")
    public void theUserClicksTheTextValueTriggerButton() {
        waitConditionsActionsUI.clickTextValueTrigger();
    }

    @Then("the alert handled confirmation message is displayed")
    public void theAlertHandledConfirmationMessageIsDisplayed() {
        waitConditionsQuestionsUI.verifyAlertHandledMessageDisplayed();
    }

    @Then("the confirm response OK message is displayed")
    public void theConfirmResponseOKMessageIsDisplayed() {
        waitConditionsQuestionsUI.verifyConfirmOKMessageDisplayed();
    }

    @Then("the confirm response Cancelled message is displayed")
    public void theConfirmResponseCancelledMessageIsDisplayed() {
        waitConditionsQuestionsUI.verifyConfirmCancelledMessageDisplayed();
    }

    @Then("the visibility target button is displayed")
    public void theVisibilityTargetButtonIsDisplayed() {
        waitConditionsQuestionsUI.verifyVisibilityTargetDisplayed();
    }

    @Then("the visibility target button is not displayed")
    public void theVisibilityTargetButtonIsNotDisplayed() {
        waitConditionsQuestionsUI.verifyVisibilityTargetNotDisplayed();
    }

    @Then("the spinner is no longer displayed")
    public void theSpinnerIsNoLongerDisplayed() {
        waitConditionsQuestionsUI.verifySpinnerNotDisplayed();
    }

    @Then("the loading spinner is displayed")
    public void theLoadingSpinnerIsDisplayed() {
        waitConditionsQuestionsUI.verifySpinnerDisplayed();
    }

    @And("the spinner gone success message is displayed")
    public void theSpinnerGoneSuccessMessageIsDisplayed() {
        waitConditionsQuestionsUI.verifySpinnerGoneMessageDisplayed();
    }

    @Then("the target button is enabled and clickable")
    public void theTargetButtonIsEnabledAndClickable() {
        waitConditionsQuestionsUI.verifyEnabledTargetIsEnabled();
    }

    @Then("the browser page title is {string}")
    public void theBrowserPageTitleIs(String expectedTitle) {
        waitConditionsQuestionsUI.verifyBrowserPageTitle(expectedTitle);
    }

    @Then("the text input contains {string}")
    public void theTextInputContains(String expectedText) {
        waitConditionsQuestionsUI.verifyTextInputContains(expectedText);
    }

    @And("the button text shows {string}")
    public void theButtonTextShows(String expectedText) {
        waitConditionsQuestionsUI.verifyButtonTextShows(expectedText);
    }
}
