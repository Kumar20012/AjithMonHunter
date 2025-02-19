Feature: Validate user can submit feedback about products

  Scenario: Verify user can give product feedback successfully
    Given user open application "MEN"
    Then verify user on home page
    When user enter search product "product.watch"
    Then verify user on product page
    When user click on the first product from product list
    Then verify the user should be on the product details page
    When user click on feedback button
    Then verify user is on feedback page
    When user fill ratings from feedback page
    And  user enter feedback about product
    And  user click on submit feedback button
    Then verify user submitted feedback successfully
