Feature: Create New User
  As an admin or authorized user
  I want to create a new user
  So that the user is registered in the system

  Scenario Outline: Create a user with name and balance
    Given the user is logged in
    And navigates to the create user page
    When the admin enters username "<username>" and balance <balance>
    Then the user should be created successfully

    Examples:
      | username   | balance |
      | JohnDoe    | 5000    |
      | Alice123   | 10000   |
