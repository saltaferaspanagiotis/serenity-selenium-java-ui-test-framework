package demo.bdd.questions;

import demo.bdd.enums.FileType;
import demo.bdd.locators.FormsPage;
import demo.bdd.utils.Download;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@Scope("prototype")
public class FormsQuestionsUI extends PageObject {

    public void verifyExperienceDisplayShows(String expectedValue) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.EXPERIENCE_VALIDATE));
        Assertions.assertEquals(expectedValue, $(FormsPage.EXPERIENCE_VALIDATE).getText().trim());
    }

    public void verifyCheckboxValidationContains(String expectedLanguage) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.CHECKBOX_VALIDATE));
        String actual = $(FormsPage.CHECKBOX_VALIDATE).getText();
        Assertions.assertTrue((actual.contains(expectedLanguage)),
                "Expected checkbox validation to contain '" + expectedLanguage + "' but was: " + actual);
    }

    public void verifyRadioValidationShows(String expectedSkill) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.RADIO_VALIDATE));
        Assertions.assertEquals(expectedSkill, $(FormsPage.RADIO_VALIDATE).getText().trim());
    }

    public void verifyToolDropdownValidationShows(String expectedLanguage) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.SELECT_TOOL_VALIDATE));
        Assertions.assertEquals(expectedLanguage, $(FormsPage.SELECT_TOOL_VALIDATE).getText().trim());
    }

    public void verifyLanguageDropdownValidationShows(String expectedLanguage) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.SELECT_LANG_VALIDATE));
        Assertions.assertEquals(expectedLanguage, $(FormsPage.SELECT_LANG_VALIDATE).getText().trim());
    }

    public void verifyGermanValidationShows(String expectedValue) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.GERMAN_VALIDATE));
        Assertions.assertEquals(expectedValue, $(FormsPage.GERMAN_VALIDATE).getText().trim());
    }

    public void verifyNotesValidationShows(String expectedText) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.NOTES_VALIDATE));
        Assertions.assertEquals(expectedText, $(FormsPage.NOTES_VALIDATE).getText().trim());
    }

    public void verifyFormValidationErrorsDisplayed() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat($(FormsPage.INVALID_CITY_ERROR).isDisplayed()).isTrue();
        softly.assertThat($(FormsPage.INVALID_STATE_ERROR).isDisplayed()).isTrue();
        softly.assertThat($(FormsPage.INVALID_ZIP_ERROR).isDisplayed()).isTrue();
        softly.assertThat($(FormsPage.INVALID_TERMS_ERROR).isDisplayed()).isTrue();
        softly.assertAll();
    }

    public void verifyReadOnlyFieldIsNotEditable() {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.READ_ONLY_TEXTBOX));
        Assertions.assertEquals("true"
                , $(FormsPage.READ_ONLY_TEXTBOX).getDomAttribute("readonly")
                ,"Expected read-only field to be disabled but it was enabled");
    }

    public void verifyFluencySliderValueIs(int expectedValue) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.FLUENCY_VALIDATE));
        int actualValue = Integer.parseInt($(FormsPage.FLUENCY_VALIDATE).getText().trim());
        Assertions.assertEquals(expectedValue, actualValue);
    }

    public void verifyCVUpload(String expectedFileName) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.VALIDATE_CV));
        Assertions.assertEquals(expectedFileName, $(FormsPage.VALIDATE_CV).getText().trim());
    }

    public void verifyFilesUpload(List<String> filePaths) {
        for (String filePath : filePaths) {
            String fileName = FileType.getFileNameBasedOnFilePath(filePath);
            Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.VALIDATE_FILES));
            String actualText = $(FormsPage.VALIDATE_FILES).getText();
            Assertions.assertTrue(actualText.contains(fileName)
                    ,"Expected uploaded files to contain '" + fileName + "' but was: " + actualText);
        }
    }

    public void verifyFileIsDownloaded(String expectedFileName) {
        Wait.browserWaitFor(3000);
        File file = Download.getFileFromLocation(System.getProperty("user.home") + File.separator + "Downloads", expectedFileName);
        Assertions.assertNotNull(file, "Expected file '" + expectedFileName + "' to be downloaded but it was not found in the download location");
        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.delete());
    }

    public void verifyNonEnglishCheckboxValidationShows(String expectedText) {
        Wait.forElementToBeDisplayed(getDriver(), $(FormsPage.NON_ENGLISH_CHECKBOX_VALIDATE));
        String actual = $(FormsPage.NON_ENGLISH_CHECKBOX_VALIDATE).getText();
        Assertions.assertEquals(expectedText, actual.trim());
    }
}
