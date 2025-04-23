Feature: Create New Bank Account
  As an User
  I want to create a new bank account
  So that I can use it for banking purpose

  Scenario Outline: Create bank account with valid data
#    Given the user has authorization access token
    Given the user has valid data for account creation
    When the user hits the POST request to the create new account endpoint
    Then the status code should be 201 for creating new account
    And the response should have "<key>" equal to "<value>"

    Examples:
      | key     | value   |
      | name    | User 3  |