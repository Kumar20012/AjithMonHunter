Feature: Validate the product search and select filter

  Scenario: verify all search details
    Given user open application "MEN"
    Then verify user on home page
    When user click login button
    Then verify user on login page
    When user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page
    When user enter search product "product.name"
    Then verify user on product page
    When the user click filter button
    Then verify the user on filter page
    When the user can select filter option "Brand"
    And user select the "Puma" brand
    When the user can select filter option "Size"
    And user select the "UK/IND-3.5" brand
    And user click the search result
    Then display the product details



