Feature: Validate the login functionality

  Background:
    Given user open application
    Then  verify user on home page
    When  user click login button
    Then  verify user on login page

  Scenario: Verify user can login successfully

    When  user enter phone number "mobile.number"
    And   fill the otp and click submit
    Then  verify success message displayed

  Scenario Outline: Verify user can not login with invalid number
    When user fill invalid numbers "<invalid.number>"
    Then verify user can not login successfully

      Examples:
      |invalid.number|
      |23244         |
      |1333356       |
      |45            |