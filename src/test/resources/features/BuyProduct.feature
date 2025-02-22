@web @android
Feature: Validate that the user can purchase a product
  Scenario: Verify the product purchase process
    Given user open application "MEN"
    Then verify user on home page
    When user click login button
    Then verify user on login page
    When user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page
    When remove the my bag products
    And user enter search product "product.name"
    Then verify user on product page
    When the user clicks on a product that contains the keyword "Fossil"
    Then verify the user should be on the product details page
    When the user clicks the add to bag button
    Then verify the item should be added to the bag
    When the user clicks on the My Bag icon
    Then verify the user should be on the My Bag page
    When the user clicks on the Coupon option
    Then verify the user should be on the coupon page
    When a valid coupon is available, the user applies it
    Then verify the user should be on the My Bag page
    When the user clicks the checkout button
    And user fill delivery address details "pin.code"
    Then verify the user should be on the checkout page
    And the user verify pay now button should be available for completing the purchase

