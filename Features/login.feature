Feature: login to application

@Desktop
  Scenario: Login to the application
    Given user in the login page
    When user enters the credential
    Then user sees the dashboard

