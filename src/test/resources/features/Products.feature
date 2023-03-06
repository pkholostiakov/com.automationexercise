Feature: Test products page functionalities

  Background: 
    When browser is open
    And user is on the home page
    And home page is visible successfully
    And user clicks Products button
    Then user is navigated to Products page
    And products page is visible successfully

  Scenario: verify the first product from the product list
    When user clicks on the first product from the product list
    Then user is navigated to the Product Details page
    And product details page is visible successfully

  Scenario: search product on the Products page
    When user enters product name in search input
    And user clicks search button near search input
    Then searched products is visible succsessfully and products related to search
