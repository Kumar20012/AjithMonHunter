Feature: Validate the user can logout

  Scenario: verify user can logout on android
    Given user open application "MEN"
    Then  verify user on home page
    When  user click login button
    Then  verify user on login page
    When  user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page
    When  user click my account icon
    And user click on logout button
    Then verify user on home page