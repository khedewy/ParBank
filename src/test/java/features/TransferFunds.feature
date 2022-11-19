Feature: Transfer funds test
  The user should have the ability to use transfer fund service

  Scenario: Transfer funds
    Given user in the home page and click on register link
    When user enter his register data an click
    And click on register and make sure that he registered successfully
    And he click to back to home page
    And click on transfers funds
    And enter the required data
    And click on transfer
    Then make sure that he used the service successfully