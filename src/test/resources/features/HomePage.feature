Feature: Check home page functionality

  Background: 
    When browser is open
    And user is on the home page
    And home page is visible successfully

  Scenario: open the test cases page and be sure everything works properly
    And user clicks Test Cases button
    Then user is navigated to Test Cases page
    And Test Cases page is visible successfully

  Scenario: scroll down and after scroll up using arrow button work properly
    When user completely scrolls down
    And user clicks scroll up arrow button
    Then user is lifted up at the very beginning of the home page
    And home page is visible successfully

  Scenario: scroll down and after scroll up work properly
    When user completely scrolls down
    And user completely scrolls up
    Then home page is visible successfully

  Scenario: Subscribe to the website updates
    And user completely scrolls down
    And user enters email address in subscription input field
    And user clicks subscribe button
    Then success message about subscription appears

  Scenario: Subscribe to the website updates from the cart page
    When user clicks cart button
    And user completely scrolls down
    And user enters email address in subscription input field
    And user clicks subscribe button
    Then success message about subscription appears
