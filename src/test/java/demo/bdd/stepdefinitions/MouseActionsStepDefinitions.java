package demo.bdd.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MouseActionsStepDefinitions extends ConfigStepDefinitions {

    @Given("the user navigates to the Mouse Actions page")
    public void theUserNavigatesToTheMouseActionsPage() {
        mouseActionsUI.navigateToMouseActionsPage();
    }

    @When("the user single clicks on the click area")
    public void theUserSingleClicksOnTheClickArea() {
        mouseActionsUI.singleClickOnClickArea();
    }

    @When("the user double clicks on the click area")
    public void theUserDoubleClicksOnTheClickArea() {
        mouseActionsUI.doubleClickOnClickArea();
    }

    @When("the user right clicks on the click area")
    public void theUserRightClicksOnTheClickArea() {
        mouseActionsUI.rightClickOnClickArea();
    }

    @When("the user hovers over the language dropdown button")
    public void theUserHoversOverTheLanguageDropdownButton() {
        mouseActionsUI.hoverOverDropdownButton();
    }

    @And("the user selects {string} from the language dropdown")
    public void theUserSelectsFromTheLanguageDropdown(String language) {
        mouseActionsUI.selectFromLanguageDropdown(language);
    }

    @When("the user drags the draggable element to the drop zone")
    public void theUserDragsTheDraggableElementToTheDropZone() {
        mouseActionsUI.dragDraggableElementToDropZone();
    }

    @Then("the click type displayed is {string}")
    public void theClickTypeDisplayedIs(String expectedType) {
        mouseActionsQuestionsUI.verifyClickTypeIs(expectedType);
    }

    @Then("the click type displayed is not {string}")
    public void theClickTypeDisplayedIsNot(String unexpectedType) {
        mouseActionsQuestionsUI.verifyClickTypeIsNot(unexpectedType);
    }

    @Then("the selected language displayed is {string}")
    public void theSelectedLanguageDisplayedIs(String expectedLanguage) {
        mouseActionsQuestionsUI.verifySelectedLanguageIs(expectedLanguage);
    }

    @Then("the selected language displayed is not {string}")
    public void theSelectedLanguageDisplayedIsNot(String unexpectedLanguage) {
        mouseActionsQuestionsUI.verifySelectedLanguageIsNot(unexpectedLanguage);
    }

    @Then("the drop success message is displayed")
    public void theDropSuccessMessageIsDisplayed() {
        mouseActionsQuestionsUI.verifyDropSuccessMessageDisplayed();
    }
}
