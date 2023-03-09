Feature: Test register user functionality

  Background: 
    When browser is open
    And user is on the home page
    And home page is visible successfully
    And user clicks on Signup or Login button
    Then user is navigated to login page
    And login page is visible successfully

  Scenario: Register User with new email
    When user enters name and email address below new user signup message
    And user clicks signup button
    Then user is navigated to sign up page
    And sign up page is visible successfully
    When user fill details: Title, Name, Email, Password, Date of birth
    And user select checkbox sign up for our newsletter
    And user select checkbox receive special offers from our partners
    And user fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And user clicks create account button
    When user is navigated to account created page
    And account created page is visible successfully
    When user clicks continue button
    And user is navigated to the home page
    And user is logged in as new user

  Scenario: Register User with existing email
    When user enters name and existing email address below new user signup message
    And user clicks signup button
    Then existing email message is appears

  Scenario: Register User and delete
    When user enters name and email address below new user signup message
    And user clicks signup button
    Then user is navigated to sign up page
    And sign up page is visible successfully
    When user fill details: Title, Name, Email, Password, Date of birth
    And user select checkbox sign up for our newsletter
    And user select checkbox receive special offers from our partners
    And user fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And user clicks create account button
    When user is navigated to account created page
    And account created page is visible successfully
    When user clicks continue button
    And user is navigated to the home page
    When user click delete account button
    Then user is navigated to account deleted page
    And account deleted page is visible successfully
    When user clicks continue button
    And user is not logged in as particular user
