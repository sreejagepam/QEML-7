
Feature: User Authentication and Logout

  Scenario Outline: Authentication with valid credentials
    Given the user is on the login page
    When the user enters username "<username>" and password "<password>"
    Then the user successfully logs in


    Examples:
      | username   | password    |
      | admin      | admin       |