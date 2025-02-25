Feature: validate user functionality
  @api
  Scenario: user validate the create user,update and delete functionality is working
    Given user wants to call "v2/user" end point
    When set header "Content-Type" to "application/json"
    Then set request body from file "create_user.json"
    When get the data "username" from json file "create_user.json"
    When user performs "post" call
    Then verify status code is 200
    And verify the field "message" is available
    And verify response body has a field "code" is "200"
    When user wants to call "v2/user/@user" end point
    And set header "Content-Type" to "application/json"
    And user performs "get" call
    Then verify status code is 200
    When user wants to call "v2/user/@user" end point
    When set header "Content-Type" to "application/json"
    Then set request body from file "update_user.json"
    When user performs "put" call
    Then verify status code is 200
    And verify response body has a field "code" is "200"
    And the response should match the JSON schema "response_schema.json"
    When user wants to call "v2/user/@user" end point
    And set header "Content-Type" to "application/json"
    And user performs "delete" call
    Then verify status code is 200













