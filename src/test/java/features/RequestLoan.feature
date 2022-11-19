Feature: Request loan test
  User can yse request loan to make a request
  Scenario: Test for Request Loan
    Given user in the home page and he click on register as a first step
    When the user enter his data
    And make sure that he registered successfully
    And click to back to home page
    And click on request loan
    And fill the requirements
    And click on apply
    Then make sure that he applied successfully