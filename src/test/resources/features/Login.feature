Feature: validate the user can login valid credential

  Scenario: verify user login with phone number
    Given user open application
    When user click the  category "MEN"
    And user enter phone number "mobile.number"
    Then verify the number is valid
    And click continue button
    And verify user on home page

    Scenario: verify user login with Invalid credential
      Given user open application
      When user click the  category "MEN"
      And user enter phone number "InValidMobile.number"
      Then verify the number is Invalid

      #new

