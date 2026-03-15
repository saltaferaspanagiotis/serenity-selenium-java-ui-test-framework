package demo.bdd.stepdefinitions;

import demo.bdd.enums.FileType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormsStepDefinitions extends ConfigStepDefinitions {

    @Given("the user navigates to the Forms page")
    public void theUserNavigatesToTheFormsPage() {
        formsActionsUI.navigateToFormsPage();
    }

    @When("the user enters {string} in the experience field")
    public void theUserEntersInTheExperienceField(String years) {
        formsActionsUI.enterExperience(years);
    }

    @When("the user selects the {string} checkbox")
    public void theUserSelectsTheCheckbox(String language) {
        formsActionsUI.selectCheckbox(language);
    }

    @And("the user selects the {string} radio button")
    public void theUserSelectsTheRadioButton(String skill) {
        formsActionsUI.selectRadioButton(skill);
    }

    @When("the user selects {string} from the languages dropdown")
    public void theUserSelectsFromTheLanguageDropdown(String language) {
        formsActionsUI.selectFromLanguageDropdown(language);
    }

    @When("the user enables the Speaks German toggle")
    public void theUserEnablesTheSpeaksGermanToggle() {
        formsActionsUI.enableGermanToggle();
    }

    @And("the user disables the Speaks German toggle")
    public void theUserDisablesTheSpeaksGermanToggle() {
        formsActionsUI.disableGermanToggle();
    }

    @When("the user enters {string} in the notes text area")
    public void theUserEntersInTheNotesTextArea(String text) {
        formsActionsUI.enterNotes(text);
    }

    @When("the user submits the validation form without filling required fields")
    public void theUserSubmitsTheValidationFormWithoutFillingRequiredFields() {
        formsActionsUI.submitValidationForm();
    }

    @Then("the experience display shows {string}")
    public void theExperienceDisplayShows(String expectedValue) {
        formsQuestionsUI.verifyExperienceDisplayShows(expectedValue);
    }

    @Then("the checkbox validation shows {string}")
    public void theCheckboxValidationShows(String expectedLanguage) {
        formsQuestionsUI.verifyCheckboxValidationContains(expectedLanguage);
    }

    @Then("the radio validation shows {string}")
    public void theRadioValidationShows(String expectedSkill) {
        formsQuestionsUI.verifyRadioValidationShows(expectedSkill);
    }

    @Then("the language dropdown validation shows {string}")
    public void theLanguageDropdownValidationShows(String expectedLanguage) {
        formsQuestionsUI.verifyLanguageDropdownValidationShows(expectedLanguage);
    }

    @Then("the german validation shows {string}")
    public void theGermanValidationShows(String expectedValue) {
        formsQuestionsUI.verifyGermanValidationShows(expectedValue);
    }

    @Then("the notes validation shows {string}")
    public void theNotesValidationShows(String expectedText) {
        formsQuestionsUI.verifyNotesValidationShows(expectedText);
    }

    @Then("the form validation errors are displayed")
    public void theFormValidationErrorsAreDisplayed() {
        formsQuestionsUI.verifyFormValidationErrorsDisplayed();
    }

    @When("the user selects {string} from the tools dropdown")
    public void theUserSelectsFromTheToolsDropdown(String tool) {
        formsActionsUI.selectFromToolDropdown(tool);
    }

    @Then("the tool dropdown validation shows {string}")
    public void theToolDropdownValidationShows(String tool) {
        formsQuestionsUI.verifyToolDropdownValidationShows(tool);
    }

    @Then("the read-only textbox is not editable")
    public void theReadOnlyTextboxIsNotEditable() {
        formsQuestionsUI.verifyReadOnlyFieldIsNotEditable();
    }

    @When("the user moves the slider to {int}")
    public void theUserMovesTheSliderTo(int value) {
        formsActionsUI.moveFluencySliderTo(value);
    }

    @Then("the slider value display shows {int}")
    public void theSliderValueDisplayShows(int value) {
        formsQuestionsUI.verifyFluencySliderValueIs(value);
    }

    @When("the user uploads a single file")
    public void theUserUploadsASingleFile() {
        formsActionsUI.uploadCV(FileType.getFilePathBasedOnType("docx"));
    }

    @Then("the file upload validation shows the uploaded file name")
    public void theFileUploadValidationShowsTheUploadedFileName() {
        formsQuestionsUI.verifyCVUpload(FileType.getFileNameBasedOnType("docx"));
    }

    @When("the user uploads multiple files")
    public void theUserUploadsMultipleFiles() {
        scenarioContext.addFilePath(FileType.getFilePathBasedOnType("docx"));
        scenarioContext.addFilePath(FileType.getFilePathBasedOnType("txt"));
        formsActionsUI.uploadMultipleFiles(scenarioContext.getFilePaths());
    }

    @Then("the file upload validation shows all uploaded file names")
    public void theFileUploadValidationShowsAllUploadedFileNames() {
        formsQuestionsUI.verifyFilesUpload(scenarioContext.getFilePaths());
    }

    @When("the user clicks the download file button")
    public void theUserClicksTheDownloadFileButton() {
        scenarioContext.setDownloadedFileName(formsActionsUI.clickDownloadButton());
    }

    @Then("file is downloaded successfully")
    public void fileIsDownloadedSuccessfully() {
        formsQuestionsUI.verifyFileIsDownloaded(scenarioContext.getDownloadedFileName());
    }

    @When("the user clicks on the {string} non english checkbox")
    public void theUserClicksOnTheNonEnglishCheckbox(String text) {
        formsActionsUI.clickNonEnglishCheckbox(text);
    }

    @Then("the checkbox validation for non english shows {string}")
    public void theCheckboxValidationForNonEnglishShows(String text) {
        formsQuestionsUI.verifyNonEnglishCheckboxValidationShows(text);
    }
}
