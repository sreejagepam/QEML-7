Feature: User Registration
  As a new user
  I want to register with valid credentials
  So that I can access my account

  Scenario Outline: Register a new user successfully
    Given the user is on the registration page
    When the user enters valid registration details with username "<username>", password "<password>", confirm password "<confirmPassword>" and email "<email>"
    Then the user account is created successfully

    Examples:
      | username   | password       | confirmPassword | email                |
      | testuser1  | password123    | password123     | testuser1@example.com|
      | testuser2  | password456    | password456     | testuser2@example.com|