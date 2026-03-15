@WaitConditions @UI
Feature: Wait Conditions
  As a user of a dynamic web application
  I want to interact with page elements that respond over time
  so that I can see expected changes in page content and state.

  Background:
    Given the user navigates to the Wait Conditions page

  @Positive @AlertHandle @WaitConditions_01 @priority:High
  Scenario: Alert is triggered and dismissed successfully
    When the user sets minimum wait to "1" and maximum wait to "5"
    And the user clicks the Show Alert trigger
    Then the alert handled confirmation message is displayed

  @Positive @ConfirmOK @WaitConditions_02 @priority:High
  Scenario: Confirm dialog OK click shows OK response
    When the user sets minimum wait to "1" and maximum wait to "5"
    And the user clicks the Show Prompt trigger and accepts the dialog
    Then the confirm response OK message is displayed

  @Positive @VisibilityTrigger @WaitConditions_03 @priority:High
  Scenario: A hidden element becomes visible after triggering the visibility action
    When the user clicks the visibility trigger button
    Then the visibility target button is displayed

  @Positive @SpinnerGone @WaitConditions_04 @priority:High
  Scenario: Triggering the invisibility action hides the spinner and shows a success message
    When the user clicks the invisibility trigger button
    Then the spinner is no longer displayed
    And the spinner gone success message is displayed

  @Positive @EnabledTrigger @WaitConditions_05 @priority:High
  Scenario: A disabled button becomes enabled after triggering the enabled action
    When the user clicks the enabled trigger button
    Then the target button is enabled and clickable

  @Positive @PageTitleChange @WaitConditions_06 @priority:High
  Scenario: Triggering the page title action updates the browser page title
    When the user clicks the page title trigger button
    Then the browser page title is "My New Title!"

  @Positive @TextPopulated @WaitConditions_07 @priority:High
  Scenario: Triggering the text value action populates the text fields
    When the user clicks the text value trigger button
    Then the text input contains "Dennis Ritchie"
    And the button text shows "Submit"

  @Negative @VisibilityNotShown @WaitConditions_08 @priority:Low
  Scenario: Visibility target is not displayed before the trigger is activated
    Then the visibility target button is not displayed

  @Negative @SpinnerPresent @WaitConditions_09 @priority:Low
  Scenario: Spinner is displayed before the invisibility trigger is activated
    Then the loading spinner is displayed

  @Negative @ConfirmCancel @WaitConditions_10 @priority:Low
  Scenario: Dismissing the confirm dialog shows the Cancelled response
    When the user sets minimum wait to "1" and maximum wait to "5"
    And the user clicks the Show Prompt trigger and dismisses the dialog
    Then the confirm response Cancelled message is displayed
