Feature: Address verification
  Background:
    Given user open application "MEN"
    Then verify user on home page
    When user click login button
    Then verify user on login page
    When user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page

  Scenario Outline: verify multiple address
    When  user click my account icon
    And user navigate to the address input page
    Then before adding the details display the existing address details
    When user enter "<PinCode>", "<FirstName>", "<LastName>", "<Address>", "<MobileNumber>"
    And user submit the address form

    Examples:
      | PinCode  |FirstName   | LastName |         Address          | MobileNumber  |
      | 600008   | Gresh      | K        | 5/7,New York,Road H      | 9876543210    |
      | 641402   | Ajith      | Mon      | 6/34,Chicago , main Road | 8765432109    |
      | 641408   | Ajay       |sunil     | 9/23,San Diego, Rash Road| 7654321098    |