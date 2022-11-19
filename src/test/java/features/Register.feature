Feature: User Registration
  The user should have the ability to register with valid data and make sure that he registered successfully.

  Scenario: User registration

    Given user in th home page and click register
    When user in the register page and enter his valid data
    And click on register
    Then he make sure that he registered successfully.