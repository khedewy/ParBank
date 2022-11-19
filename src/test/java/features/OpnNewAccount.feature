Feature: User want to opn new Account
  The should be able to open new account an enter his data
  Scenario: opening new account to the user
    Given User in the home page an click on register to make the registration first
    When He enter his registration data
    And click on register button to register
    And make sure that he registered successfully
    And Back to home page and click on open new account
    And fill his new account data
    And  click on open new account
    Then he makes sure that he opened his new account successfully