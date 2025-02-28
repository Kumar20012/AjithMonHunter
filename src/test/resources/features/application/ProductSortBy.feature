@web @android
Feature: Validate sort by functionality on products

  Background:
    Given user open application "MEN"
    Then verify user on home page
    When user enter search product "product.name"
    Then verify user on product page

  Scenario: Verify user sort products by prices from low to high
    And the user selects the Sort by option and chooses "Price Low to High"
    Then verify all listed products are displayed in ascending order price

  Scenario: Verify user sort products by popularity
    And  the user selects the Sort by option and chooses "Popularity"
    Then verify all listed products are sorted by popularity

  Scenario:  Verify user sort products by prices from high to low
    And the user selects the Sort by option and chooses "Price High to Low"
    Then verify all listed products are displayed in descending order price

  Scenario:  Verify user can sort products by new arrivals
    And the user selects the Sort by option and chooses "New Arrivals"
    Then verify all listed products are displayed based on new arrival

  Scenario:  Verify user can sort products by new discounts
    And the user selects the Sort by option and chooses "Discounts"
    Then verify user should see product prices sorted by discounts
