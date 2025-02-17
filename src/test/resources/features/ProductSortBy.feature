Feature: Validate sort by functionality on products

  Background:
    Given user open application "MEN"
    Then verify user on home page
    When user enter search product "product.name"
    Then verify user on product page

  Scenario: Verify user can get prices sorted by popularity
    When user selects the product "product.category"
    And  the user selects the Sort by option and chooses "Popularity"
    Then verify that the prices of all listed products are displayed by popularity

  Scenario: Verify user can get prices sorted from low to high
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "Price Low to High"
    Then verify that the prices of all listed products are displayed in ascending order

  Scenario: Verify user can get prices sorted from high to low
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "Price High to Low"
    Then verify that the prices of all listed products are displayed in descending order

  Scenario:  Verify user can get prices sorted by new arrivals
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "New Arrivals"
    Then verify user should see product names sorted by new arrivals

  Scenario:  Verify user can get prices sorted by discounts
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "Discounts"
    Then verify user should see product prices sorted by discounts
