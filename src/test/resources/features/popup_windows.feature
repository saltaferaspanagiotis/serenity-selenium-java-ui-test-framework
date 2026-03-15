@PopupWindows @UI
Feature: Popup Windows
  As a user of a multi-window web application
  I want to open and interact with content in new browser windows
  so that I can work across multiple windows without losing my place.

  Background:
    Given the user navigates to the Popup Windows page

  @Positive @OpenWindowClick @PopupWindows_01 @priority:High
  Scenario Outline: Opening <window> and clicking its button changes the button text to Clicked
    When the user opens "<window>"
    And the user switches to the new browser window
    And the user clicks the button in the new window
    Then the button text in the new window is "Clicked"
    Examples:
      | window       |
      | New Window 1 |
      | New Window 2 |

  @Positive @SwitchBack @PopupWindows_02 @priority:High
  Scenario: After switching to a new window, switching back makes the original window active
    When the user opens "New Window 1"
    And the user switches to the new browser window
    And the user switches back to the original window
    Then the Popup Windows page is displayed

  @Negative @ButtonNotClickedInitially @PopupWindows_03 @priority:Low
  Scenario: Button in New Window 1 is not already showing Clicked before user clicks it
    When the user opens "New Window 1"
    And the user switches to the new browser window
    Then the button text in the new window is not "Clicked"
