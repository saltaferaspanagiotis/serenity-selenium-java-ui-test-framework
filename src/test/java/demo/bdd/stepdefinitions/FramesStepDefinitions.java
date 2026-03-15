package demo.bdd.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FramesStepDefinitions extends ConfigStepDefinitions {

    @Given("the user navigates to the Frames page")
    public void theUserNavigatesToTheFramesPage() {
        framesActionsUI.navigateToFramesPage();
    }

    @When("the user switches to the {int} iframe on the page")
    public void theUserSwitchesToTheFirstIframeOnThePage(int iframeIndex) {
        framesActionsUI.switchToFirstIframe(iframeIndex);
        scenarioContext.setFrameIndex(iframeIndex);
    }

    @And("the user clicks the button inside the frame")
    public void theUserClicksTheButtonInsideTheFrame() {
        framesActionsUI.clickButtonInsideFrame(scenarioContext.getFrameIndex());
    }

    @And("the user switches back to the main document")
    public void theUserSwitchesBackToTheMainDocument() {
        framesActionsUI.switchBackToMainDocument();
    }

    @Then("the button inside the frame shows {string}")
    public void theButtonInsideTheFrameShows(String expectedText) {
        framesQuestionsUI.verifyInnerButtonTextIs(expectedText, scenarioContext.getFrameIndex());
    }

    @Then("the Frames page heading is displayed")
    public void theFramesPageHeadingIsDisplayed() {
        framesQuestionsUI.verifyFramesPageHeadingIsDisplayed(true);
    }

    @Then("the Frames page heading is not visible in the frame")
    public void theFramesPageHeadingIsNotReadableInTheFrame() {
        framesQuestionsUI.verifyFramesPageHeadingIsDisplayed(false);
    }
}
