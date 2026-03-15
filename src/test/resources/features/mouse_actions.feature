@MouseActions @UI
Feature: Mouse Actions
  As a user navigating a web application with a mouse
  I want my pointer interactions to be captured and reflected on the page
  so that I can confirm the application handles mouse events correctly.

  Background:
    Given the user navigates to the Mouse Actions page

  @Positive @SingleClick @MouseActions_01 @priority:High
  Scenario: Single clicking the click area registers a click event
    When the user single clicks on the click area
    Then the click type displayed is "Click"

  @Positive @DoubleClick @MouseActions_02 @priority:High
  Scenario: Double clicking the click area registers a double-click event
    When the user double clicks on the click area
    Then the click type displayed is "Double-Click"

  @Positive @RightClick @MouseActions_03 @priority:High
  Scenario: Right clicking the click area registers a context menu event
    When the user right clicks on the click area
    Then the click type displayed is "Right-Click"

  @Positive @DropdownLanguage @MouseActions_04 @priority:High
  Scenario Outline: Hovering over the dropdown and selecting a language displays the selected language
    When the user hovers over the language dropdown button
    And the user selects "<language>" from the language dropdown
    Then the selected language displayed is "<language>"
    Examples:
      | language   |
      | Java       |
      | Python     |
      | JavaScript |

  @Positive @DragAndDrop @MouseActions_05 @priority:High
  Scenario: Dragging the draggable element to the drop zone shows drop success message
    When the user drags the draggable element to the drop zone
    Then the drop success message is displayed

  @Negative @NegativeClickType @MouseActions_06 @priority:Low
  Scenario: Single clicking the click area does not register a double-click event
    When the user single clicks on the click area
    Then the click type displayed is not "Double-Click"

  @Negative @DropdownLanguageMismatch @MouseActions_07 @priority:Low
  Scenario: Selecting Python from the dropdown does not display Java as the selected language
    When the user hovers over the language dropdown button
    And the user selects "Python" from the language dropdown
    Then the selected language displayed is not "Java"
