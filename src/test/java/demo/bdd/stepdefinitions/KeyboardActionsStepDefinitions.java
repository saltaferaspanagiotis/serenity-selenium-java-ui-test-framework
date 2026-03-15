package demo.bdd.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KeyboardActionsStepDefinitions extends ConfigStepDefinitions {

    @Given("the user navigates to the Keyboard Actions page")
    public void theUserNavigatesToTheKeyboardActionsPage() {
        keyboardActionsUI.navigateToKeyboardActionsPage();
    }

    @When("the user types the character {string} in the keyboard area")
    public void theUserTypesTheCharacterInTheKeyboardArea(String character) {
        keyboardActionsUI.typeCharacterInArea(character);
    }

    @Then("the detected key name is {string}")
    public void theDetectedKeyNameIs(String expectedKey) {
        keyboardActionsQuestionsUI.verifyDetectedKeyName(expectedKey);
    }

    @Then("the detected key display is empty")
    public void theDetectedKeyDisplayIsEmpty() {
        keyboardActionsQuestionsUI.verifyKeyDisplayIsEmpty();
    }
}
