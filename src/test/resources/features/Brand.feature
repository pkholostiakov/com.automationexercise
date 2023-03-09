Feature: Test brand functionalities

  Background: 
    When browser is open
    And user is on the home page
    And home page is visible successfully

  Scenario: view brand products page is matches with selected brand
    When user clicks some of brand
    Then user is navigated to brand products page
    And brand products page is visible successfully
    And products at the page is match with selected brand
    When user clicks some of brand
    And products at the page is match with selected brand
