Feature: Validate the login functionality

  Background:
    Given user open application "MEN"
    Then  verify user on home page
    When  user click login button
    Then  verify user on login page

  Scenario: Verify user can login successfully
    When  user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page

  Scenario Outline: Verify user can not login with invalid number
    When user fill invalid numbers "<invalid.number>"
    Then verify the number is Invalid

      Examples:
      |invalid.number|
      |23244         |
      |1333356       |
      |45            |