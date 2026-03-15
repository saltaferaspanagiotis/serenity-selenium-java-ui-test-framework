package demo.bdd.locators;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class FormsPage extends UIInteractions {

    public static final String PAGE_URL = "https://play1.automationcamp.ir/forms.html";

    // Experience text input and its live validation display
    public static final By EXPERIENCE_INPUT = By.id("exp");
    public static final By EXPERIENCE_VALIDATE = By.id("exp_help");

    // Programming language checkboxes and validation display
    public static final By CHECK_JAVA = By.id("check_java");
    public static final By CHECK_PYTHON = By.id("check_python");
    public static final By CHECK_JAVASCRIPT = By.id("check_javascript");
    public static final By CHECKBOX_VALIDATE = By.id("check_validate");

    // Primary skill radio buttons and validation display
    public static final By RADIO_SELENIUM = By.id("rad_selenium");
    public static final By RADIO_PROTRACTOR = By.id("rad_protractor");
    public static final By RADIO_VALIDATE = By.id("rad_validate");

    // Notes text area and validation display
    public static final By NOTES_AREA = By.id("notes");
    public static final By NOTES_VALIDATE = By.id("area_notes_validate");

    // Language tool single-select dropdown and validation display
    public static final By SELECT_TOOL = By.id("select_tool");
    public static final By SELECT_TOOL_VALIDATE = By.id("select_tool_validate");

    // Language multi-select dropdown and validation display
    public static final By SELECT_LANG = By.id("select_lang");
    public static final By SELECT_LANG_VALIDATE = By.id("select_lang_validate");

    // Speaks German toggle and validation display
    public static final By GERMAN_TOGGLE = By.id("german");
    public static final By GERMAN_TOGGLE_LABEL = By.cssSelector("label[for='german']");
    public static final By GERMAN_VALIDATE = By.id("german_validate");

    // Fluency range slider and validation display
    public static final By FLUENCY_SLIDER = By.id("fluency");
    public static final By FLUENCY_VALIDATE = By.id("fluency_validate");

    // File upload inputs and validation displays
    public static final By UPLOAD_CV = By.id("upload_cv");
    public static final By VALIDATE_CV = By.id("validate_cv");
    public static final By UPLOAD_FILES = By.id("upload_files");
    public static final By VALIDATE_FILES = By.id("validate_files");
    public static final By DOWNLOAD_BTN = By.id("download_file");

    // Bootstrap validation form — submit button and invalid feedback messages
    public static final By VALIDATION_SUBMIT_BTN = By.cssSelector("button[type='submit']");
    public static final By CITY = By.id("validationCustom03");
    public static final By INVALID_CITY_ERROR = By.id("invalid_state");
    public static final By STATE = By.id("validationCustom04");
    public static final By INVALID_STATE_ERROR = By.id("invalid_state");
    public static final By ZIP = By.id("validationCustom05");
    public static final By INVALID_ZIP_ERROR = By.id("invalid_zip");
    public static final By CHECK_AGREE_TERMS_AND_CONDITIONS = By.id("invalidCheck");
    public static final By INVALID_TERMS_ERROR = By.id("invalid_terms");

    // Read only textbox
    public static final By READ_ONLY_TEXTBOX = By.id("common_sense");

    // Non-English check boxes (using dynamic locator method)
    public static By nonEnglishCheckboxOption(String text) {
        return By.cssSelector("label[for='" + text + "']");
    }

    public static final By NON_ENGLISH_CHECKBOX_VALIDATE = By.id("check_validate_non_english");
}
