@KeyboardActions @UI
Feature: Keyboard Actions
  As a user of a keyboard-driven web application
  I want my key presses to be detected and displayed
  so that I can verify the application captures keyboard input correctly.

  Background:
    Given the user navigates to the Keyboard Actions page

  @Positive @KeyName @KeyboardActions_01 @priority:High
  Scenario Outline: Typing a key in the keyboard area displays the correct key name
    When the user types the character "<key>" in the keyboard area
    Then the detected key name is "<key>"
    Examples:
      | key       |
      | Control   |
      | Alt       |
      | Home      |
      | ArrowDown |
      | PageUp    |

  @Negative @EmptyOnLoad @KeyboardActions_02 @priority:Low
  Scenario: No key information is shown before any key is pressed
    Then the detected key display is empty
