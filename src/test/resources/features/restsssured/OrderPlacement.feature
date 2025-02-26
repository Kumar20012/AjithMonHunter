@api
Feature: Validate the user can place order
  Scenario: Validate the order placement
    Given user wants to call "v2/store/order" end point
    When set header "Content-Type" to "application/json"
    And set request body from using pojo "order_placement.json"
    And user performs "post" call
    Then verify status code is 200
    And verify response body matches request body
    When store response "id" into "order.id"
    And user wants to call "v2/store/order/{id}" end point
    Then set path param "id" to "order.id"
    And user performs "get" call
    Then verify status code is 200
    And the response should match the JSON schema "order_schema.json"




