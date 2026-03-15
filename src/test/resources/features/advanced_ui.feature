@AdvancedUI @UI
Feature: Advanced UI Features
  As a user of an interactive book rating application
  I want to enter the correct star rating for a book
  so that I receive feedback on whether my rating matches the displayed rating.

  Background:
    Given the user navigates to the Advanced UI page

  @Positive @CorrectRating @AdvancedUI_01 @priority:High
  Scenario: Entering the correct book rating shows the Well done! success message
    When the user reads the book rating from the page
    And the user enters the extracted rating in the rating input field
    And the user clicks the Check Rating button
    Then the rating validation message shows "Well done!"

  @Negative @WrongRating @AdvancedUI_02 @priority:Low
  Scenario: Entering an incorrect book rating shows the Try Again! message
    When the user enters "******" in the rating input field
    And the user clicks the Check Rating button
    Then the rating validation message shows "Try Again!"

  @Negative @EmptyRating @AdvancedUI_03 @priority:Low
  Scenario: Clicking Check Rating with no input entered shows the Try Again! message
    When the user clicks the Check Rating button
    Then the rating validation message shows "Try Again!"
