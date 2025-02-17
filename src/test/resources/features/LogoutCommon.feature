Feature: Validate the user can logout

  @Android
  Scenario: verify user can logout on android
    Given user open application "MEN"
    Then  verify user on home page
    When  user click login button
    Then  verify user on login page
    When  user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page
    When  user click login button
    Then



  @Web
  Scenario: verify user can logout on web
    Given user open application "MEN"
    Then  verify user on home page
    When  user click login button
    Then  verify user on login page
    When  user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page
    When  user click login button