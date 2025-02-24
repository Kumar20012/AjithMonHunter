@web @android
Feature: Validate the expand Button
  Scenario: verify expand is working
    Given user open application "MEN"
    Then verify user on home page
    And user enter search product "product.name"
    Then verify user on product page
    When the user click expand button
    Then verify the button is working
