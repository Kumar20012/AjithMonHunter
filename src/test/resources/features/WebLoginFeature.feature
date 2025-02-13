Feature: validate the user can login with valid credential

  Scenario: verify user can login successfully
    Given user open application
    Then  verify user on home page
    When  user click login button
    And   user enter phone number "mobile.number"
    Then  click continue button
