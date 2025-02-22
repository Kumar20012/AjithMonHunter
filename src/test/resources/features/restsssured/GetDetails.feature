Feature: validate user section

  @api
  Scenario: create user
    Given user wants to call "v2/user" end point
    When set header "Content-Type" to "application/json"
    Then set request body from file "create_user.json"
    When get the user name from json file
    When user performs "post" call
    Then verify status code is 200
    And verify response body has a field "code" is "200"

  @api
  Scenario: verify the user details
    Given user wants to call "v2/user/ranjith" end point
    When set header "Content-Type" to "application/json"
    When user performs "get" call
    Then verify status code is 200










