@Frames @UI
Feature: Frame Interactions
  As a user of a web page that embeds content in frames
  I want to interact with content inside embedded frames
  so that I can use all features of the page regardless of how they are structured.

  Background:
    Given the user navigates to the Frames page

  @Positive @SwitchToFrame @Frames_01 @priority:High
  Scenario Outline: User can switch to the iframe and interact with the button inside it
    When the user switches to the <index> iframe on the page
    And the user clicks the button inside the frame
    Then the button inside the frame shows "Clicked"
    Examples:
      | index |
      | 1     |
      | 2     |
      | 4     |

  @Positive @SwitchBackFromFrame @Frames_02 @priority:High
  Scenario: After interacting with a frame, user can switch back to the main document
    When the user switches to the 1 iframe on the page
    And the user clicks the button inside the frame
    And the user switches back to the main document
    Then the Frames page heading is displayed

  @Negative @SwitchBackFromFrame @Frames_03 @priority:Low
  Scenario: After switching in a frame, user cannot interact with main document elements
    When the user switches to the 1 iframe on the page
    Then the Frames page heading is not visible in the frame
