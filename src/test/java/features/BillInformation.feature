Feature: User can use bill pay services
  User can user bill pay services to pay his payments

  Scenario: User can use bill pay services
    Given User in the home page in click on register
    When User in register page and enter his data
    And user is sur that he registered successfully
    And click on bill services button
    And he fills his information
    And click on send button
    Then make sure that he used the service successfully