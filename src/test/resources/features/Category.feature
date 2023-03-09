Feature: Test category functionalities

  Background: 
    When browser is open
    And user is on the home page
    And home page is visible successfully

  Scenario: view category products page is matches with selected category and subcategory
    When user clicks some of category and subcategory
    Then user is navigated to category products page
    And category products page is visible successfully
    And products at the page is match with selected category and subcategory
    When user clicks some of category and subcategory
    And products at the page is match with selected category and subcategory
