Feature: Validate the product search and select filter
  Background:
    Given user open application "MEN"
    Then verify user on home page
    When user click login button
    Then verify user on login page
    When user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page
    When user enter search product "product.shoe"
    Then verify user on product page

  @web @android
  Scenario: verify all search details
    When the user can select filter option "Brand"
    And user select the "Puma" brand
    When the user can select filter option "Size"
    And user select the "UK/IND-3.5" brand
    Then display the product details

  @android
  Scenario: Verify user can add and delete product in wish list
    When user add the product into wish list
    Then verify product added in wish list successfully
    When user delete the product from wish list
    Then verify product deleted from wish list successfully



