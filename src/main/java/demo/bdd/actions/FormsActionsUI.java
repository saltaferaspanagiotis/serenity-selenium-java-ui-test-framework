package demo.bdd.actions;

import demo.bdd.locators.FormsPage;
import demo.bdd.utils.Element;
import demo.bdd.utils.Upload;
import demo.bdd.utils.Wait;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

@Component
@Scope("prototype")
public class FormsActionsUI extends PageObject {

    public void navigateToFormsPage() {
        openAt(FormsPage.PAGE_URL);
        Wait.forElementToBeClickable(getDriver(), $(FormsPage.EXPERIENCE_INPUT));
    }

    public void enterExperience(String years) {
        $(FormsPage.EXPERIENCE_INPUT).clear();
        $(FormsPage.EXPERIENCE_INPUT).type(years);
    }

    public void selectCheckbox(String language) {
        switch (language) {
            case "Java":
                $(FormsPage.CHECK_JAVA).click();
                break;
            case "Python":
                $(FormsPage.CHECK_PYTHON).click();
                break;
            case "JavaScript":
                $(FormsPage.CHECK_JAVASCRIPT).click();
                break;
            default:
                throw new IllegalArgumentException("Unknown checkbox option: " + language);
        }
    }

    public void selectRadioButton(String skill) {
        switch (skill) {
            case "Selenium":
                $(FormsPage.RADIO_SELENIUM).click();
                break;
            case "Protractor":
                $(FormsPage.RADIO_PROTRACTOR).click();
                break;
            default:
                throw new IllegalArgumentException("Unknown radio option: " + skill);
        }
    }

    public void selectFromToolDropdown(String tool) {
        $(FormsPage.SELECT_TOOL).selectByVisibleText(tool);
    }

    public void selectFromLanguageDropdown(String language) {
        $(FormsPage.SELECT_LANG).selectByVisibleText(language);
    }

    public void enableGermanToggle() {
        if (!$(FormsPage.GERMAN_TOGGLE).isSelected()) {
            $(FormsPage.GERMAN_TOGGLE_LABEL).click();
        }
    }

    public void disableGermanToggle() {
        if ($(FormsPage.GERMAN_TOGGLE).isSelected()) {
            $(FormsPage.GERMAN_TOGGLE_LABEL).click();
        }
    }

    public void enterNotes(String text) {
        $(FormsPage.NOTES_AREA).clear();
        $(FormsPage.NOTES_AREA).type(text);
    }

    public void submitValidationForm() {
        $(FormsPage.VALIDATION_SUBMIT_BTN).click();
    }

    public void fillInRequiredFormFields() {
        $(FormsPage.CITY).type("Athens");
        $(FormsPage.STATE).type("Attica");
        $(FormsPage.ZIP).type("12345");
        if (!$(FormsPage.CHECK_AGREE_TERMS_AND_CONDITIONS).isSelected()) {
            $(FormsPage.CHECK_AGREE_TERMS_AND_CONDITIONS).click();
        }
    }

    public void moveFluencySliderTo(int value) {
        Wait.forElementToBeClickable(getDriver(), $(FormsPage.FLUENCY_SLIDER));
        $(FormsPage.FLUENCY_SLIDER).click();
        int currentValue = Integer.parseInt($(FormsPage.FLUENCY_VALIDATE).getText());
        while (currentValue < value) {
            $(FormsPage.FLUENCY_SLIDER).sendKeys(Keys.ARROW_RIGHT);
            currentValue++;
        }
        while (currentValue > value) {
            $(FormsPage.FLUENCY_SLIDER).sendKeys(Keys.ARROW_LEFT);
            currentValue--;
        }
    }

    public void uploadCV(String filePath) {
        Upload.setLocalFileDetectorIfGrid(getDriver());
        $(FormsPage.UPLOAD_CV).sendKeys(new File(filePath).getAbsolutePath());
    }

    public void uploadMultipleFiles(List<String> filePaths) {
        Upload.setLocalFileDetectorIfGrid(getDriver());
        String combinedFilePaths = String.join("\n", filePaths.stream()
                .map(path -> new File(path).getAbsolutePath())
                .toArray(String[]::new));
        $(FormsPage.UPLOAD_FILES).sendKeys(combinedFilePaths);
    }

    public String clickDownloadButton() {
        $(FormsPage.DOWNLOAD_BTN).click();
        return String.valueOf(Paths.get($(FormsPage.DOWNLOAD_BTN).getDomAttribute("href")).getFileName());
    }

    public void clickNonEnglishCheckbox(String text) {
        Element.scrollIntoView(getDriver(), $(FormsPage.nonEnglishCheckboxOption(text)));
        $(FormsPage.nonEnglishCheckboxOption(text)).click();

    }
}
