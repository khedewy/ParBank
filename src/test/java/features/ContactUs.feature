Feature: User can use contact us service
  if the user want to contact with the owners of the website or complaints team
  Scenario: user can use contact service
    Given user in the home page an click on contact us
    When he enter his information
    Then make sure that his message sent successfully