Feature: Validate the product prices and coupons discounts
  Background:
    Given user open application "MEN"
    Then verify user on home page
    When user click login button
    Then verify user on login page
    When user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page

    Scenario: Validate quantity price then increase the price
      And user enter search product "product.watch"
      Then verify user on product page
      When user click on the first product from product list
      And the user click buy now button
      Then verify the user should be on the My Bag page
      When user increase the quantity of product to "product.quantity"
      Then verify the product price equal to quantity increase price

