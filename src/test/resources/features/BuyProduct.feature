Feature: validate user buy a product
  Scenario: validate
    Given user open application
    When user click the  category "MEN"
    And user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    And verify user on home page
    When user search the product "product.name"
    Then verify user on product page

