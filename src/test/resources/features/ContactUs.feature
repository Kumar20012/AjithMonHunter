Feature: Validate contact us functionality
  Background:
    Given user open application "MEN"
    Then verify user on home page
    When user click login button
    Then verify user on login page
    When user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    Then verify user on home page
    When  user click my account icon
    And  user click on customer care button
    Then verify user is on customer support page

  Scenario Outline: Verify user can raise tickets about application related issues
    When user select issue type "<issue.type>" and submit
    Then verify contact us option is displayed
    When user click on contact us button
    And  user select the raise a complaint option
    Then verify the ticket raising tab is displayed
    When user fill the details about issue and click next Button
    And  user upload the attachment on particular issue and submit
    Then verify user can submit the complaint successfully

    Examples:

    |issue.type             |
    |Product related        |
    |Website related        |
    |Promotions & Offers    |
    |EGV / CLiQ Point       |

Scenario Outline: Verify user can raise multiple tickets on one particular issue type
  When user select issue type "Website related"
  And  user select various options "<ticket.options>" from suggestions
  When user click on contact us button
  And  user select the raise a complaint option
  Then verify the ticket raising tab is displayed
  When user fill the details about issue and click next Button
  And  user upload the attachment on particular issue and submit
  Then verify user can submit the complaint successfully

  Examples:
  |ticket.options|
  |I am unable to place an order               |
  |I am getting pricing error                  |
  |Report content error                        |
  |Unsubscribe from promotional emails         |
  |I want to update/ edit my personal details  |

