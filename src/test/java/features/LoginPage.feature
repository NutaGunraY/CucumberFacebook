Feature: Check All features on Login Page
  Background:
    Given open the GoogleChrome browser and goes to Facebook page
  Scenario:
    When user enters the password and clicks on show password button
    Then the password will be showed
  Scenario:
    When user presses on Create user button
    Then it will open the mini tab to create the user
  Scenario:
    When user presses on forget password button
    Then it will transfer to recover page and check it if this page works
  Scenario:
    When user sees links on the bottom
    Then validate all urls
  Scenario:
    When user provides all the information
    Then log in

