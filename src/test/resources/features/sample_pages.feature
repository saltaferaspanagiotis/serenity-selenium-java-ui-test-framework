@SamplePages @UI
Feature: Sample Pages - Login
  As a registered user of the PizzaHouse application
  I want to log in to the system using the login form
  so that I can access the pizza ordering page when credentials are valid,
  and receive a clear error message when credentials are invalid.

  Background:
    Given the user navigates to the Sample Pages login page

  @Positive @ValidLogin @SamplePages_01 @priority:High
  Scenario: Logging in with valid credentials redirects to the Pizza House page
    When the user enters valid credentials
    Then the user is redirected to the "Dinesh's Pizza House" page

  @Negative @InvalidCredentials @SamplePages_02 @priority:Low
  Scenario Outline: Logging in with invalid <credential_type> shows an error message
    When the user enters credentials with invalid "<credential_type>"
    Then the login error message is displayed
    Examples:
      | credential_type |
      | username        |
      | password        |
