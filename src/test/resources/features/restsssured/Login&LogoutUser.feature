@api
Feature: verify the user can successfully login and logout
  Scenario: validate user can login and logout
    Given user wants to call "v2/user/login?username=@name&password=@pass" end point
    When set header "Content-Type" to "application/json"
    And user performs "get" call
    Then verify status code is 200
    And verify response body has a field "code" is "200"
    When user wants to call "v2/user/logout" end point
    And user performs "get" call
    Then verify status code is 200
    And verify response body has a field "message" is "ok"
