@Forms @UI
Feature: Forms
  As a user filling in a web form
  I want to interact with all form elements on the page
  so that my inputs are captured and validated correctly.

  Background:
    Given the user navigates to the Forms page

  @Positive @ExperienceInput @Forms_01 @priority:High
  Scenario: Entering years of experience updates the experience display
    When the user enters "5" in the experience field
    Then the experience display shows "5"

  @Positive @CheckboxSelection @Forms_02 @priority:High
  Scenario: Selecting Javascript and Python checkboxes shows both in the validation display
    When the user selects the "JavaScript" checkbox
    And the user selects the "Python" checkbox
    Then the checkbox validation shows "PYTHON JAVASCRIPT"

  @Positive @RadioButton @Forms_03 @priority:High
  Scenario: Selecting the Selenium radio button shows Selenium in the validation display
    When the user selects the "Selenium" radio button
    Then the radio validation shows "SELENIUM"

  @Positive @LanguageDropdown @Forms_04 @priority:High
  Scenario: Selecting single option from dropdown shows the selected value in the validation display
    When the user selects "Cypress" from the tools dropdown
    Then the tool dropdown validation shows "cyp"

  @Positive @LanguageDropdown @Forms_05 @priority:High
  Scenario: Selecting multiple options from dropdown shows the selected values in the validation display
    When the user selects "Java" from the languages dropdown
    And the user selects "Python" from the languages dropdown
    Then the language dropdown validation shows "java,python"

  @Positive @GermanToggleOn @Forms_06 @priority:High
  Scenario: Enabling the Speaks German toggle shows true when the toggle is enabled
    When the user enables the Speaks German toggle
    Then the german validation shows "true"

  @Negative @GermanToggleOff @Forms_07 @priority:Low
  Scenario: German toggle validation shows false when the toggle is disabled
    And the user enables the Speaks German toggle
    When the user disables the Speaks German toggle
    Then the german validation shows "false"

  @Positive @NotesInput @Forms_08 @priority:High
  Scenario: Entering notes in the text area shows the text in the notes validation display
    When the user enters "Test automation is great" in the notes text area
    Then the notes validation shows "Test automation is great"

  @Negative @RequiredFieldValidation @Forms_09 @priority:Low
  Scenario: Submitting the validation form without filling required fields shows validation errors
    When the user submits the validation form without filling required fields
    Then the form validation errors are displayed

  @Negative @ReadOnlyTextbox @Forms_10 @priority:Low
  Scenario: Interacting with Read Only textbox does not allow changes to the text
    When the user navigates to the Forms page
    Then the read-only textbox is not editable

  @Positive @SliderValue @Forms_11 @priority:High
  Scenario: Moving the slider updates the slider value display
    When the user moves the slider to 5
    Then the slider value display shows 5

  @Positive @FileUploadSingle @Forms_12 @priority:High
  Scenario: Uploading a file shows the file name in the validation display
    When the user uploads a single file
    Then the file upload validation shows the uploaded file name

  @Positive @FileUploadMultiple @Forms_13 @priority:High
  Scenario: Uploading multiple files shows all file names in the validation display
    When the user uploads multiple files
    Then the file upload validation shows all uploaded file names

  @Positive @FileDownload @Forms_14 @priority:High
  Scenario: File download
    When the user clicks the download file button
    Then file is downloaded successfully

  Scenario Outline: Interacting with Non-English Locators
    When the user clicks on the "<text>" non english checkbox
    Then the checkbox validation for non english shows "<text>"
    Examples:
      | text    |
      | मराठी   |
      | ગુજરાતી |
      | ਪੰਜਾਬੀ  |
