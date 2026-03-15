package demo.bdd.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdvancedUIGenericStepDefinitions extends ConfigStepDefinitions {

    @Given("the user navigates to the Advanced UI page")
    public void theUserNavigatesToTheAdvancedUIPage() {
        advancedUIActionsUI.navigateToAdvancedUIPage();
    }

    @When("the user reads the book rating from the page")
    public void theUserReadsTheBookRatingFromThePage() {
        scenarioContext.setRating(advancedUIActionsUI.extractBookRating());
    }

    @And("the user enters the extracted rating in the rating input field")
    public void theUserEntersTheExtractedRatingInTheRatingInputField() {
        advancedUIActionsUI.enterRatingInInputField(scenarioContext.getRating());
    }

    @When("the user enters {string} in the rating input field")
    public void theUserEntersInTheRatingInputField(String rating) {
        advancedUIActionsUI.enterRatingInInputField(rating);
    }

    @And("the user clicks the Check Rating button")
    public void theUserClicksTheCheckRatingButton() {
        advancedUIActionsUI.clickCheckRatingButton();
    }

    @Then("the rating validation message shows {string}")
    public void theRatingValidationMessageShows(String expectedMessage) {
        advancedUIQuestionsUI.verifyRatingValidationMessageShows(expectedMessage);
    }
}
