package demo.bdd.stepdefinitions;

import demo.bdd.configuration.TestConfig;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SamplePagesStepDefinitions extends ConfigStepDefinitions {

    @After()
    public void tearDown() {
        samplePagesActionsUI.quitBrowser();
    }

    @Given("the user navigates to the Sample Pages login page")
    public void theUserNavigatesToTheSamplePagesLoginPage() {
        samplePagesActionsUI.navigateToLoginPage();
    }

    @Then("the user is redirected to the {string} page")
    public void theUserIsRedirectedToThePage(String expectedTitle) {
        samplePagesQuestionsUI.verifyRedirectedToPizzaHousePage(expectedTitle);
    }

    @Then("the login error message is displayed")
    public void theLoginErrorMessageIsDisplayed() {
        samplePagesQuestionsUI.verifyLoginErrorMessageDisplayed();
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        TestConfig.User user = testConfig.getUsers().getValidUser();
        samplePagesActionsUI.enterUsername(user.getUsername());
        samplePagesActionsUI.enterPassword(user.getPassword());
        samplePagesActionsUI.clickLoginButton();
    }

    @When("the user enters credentials with invalid {string}")
    public void theUserEntersCredentialsWithInvalid(String type) {
        if (type.equalsIgnoreCase("username")) {
            TestConfig.User user = testConfig.getUsers().getInvalidUsername();
            samplePagesActionsUI.enterUsername(user.getUsername());
            samplePagesActionsUI.enterPassword(user.getPassword());
        } else if (type.equalsIgnoreCase("password")) {
            TestConfig.User user = testConfig.getUsers().getInvalidPassword();
            samplePagesActionsUI.enterUsername(user.getUsername());
            samplePagesActionsUI.enterPassword(user.getPassword());
        } else {
            throw new IllegalArgumentException("Invalid credential type: " + type);
        }
        samplePagesActionsUI.clickLoginButton();
    }
}
