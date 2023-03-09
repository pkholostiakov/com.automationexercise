Feature: Test login user functionality

  Background: 
    When browser is open
    And user is on the home page
    And home page is visible successfully
    And user clicks on Signup or Login button
    Then user is navigated to login page
    And login page is visible successfully

  Scenario: Login with valid credentials
    When user enters valid credentials below login to your accout
    And user clicks login button
    And user is navigated to the home page
    And user is logged in as particular user

  Scenario: Login with invalid credentials
    When user enters invalid credentials below login to your accout
    And user clicks login button
    Then invalid credentials message is appears
