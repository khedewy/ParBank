Feature: Update profile
  User can update his personal information of his profile

  Scenario: Updating profile
    Given User in the th home page and click on register link to register
    When he enters his personal information and click on register
    And make sure that he registered successfully
    And click on update profile
    And enter his new data
    And click on Update
    Then make sure that his information updated