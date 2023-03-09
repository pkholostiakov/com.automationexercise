Feature: Test feedback functionality

  Scenario Outline: Leave a feedback with filling out contact us form
    When browser is open
    And user is on the home page
    And home page is visible successfully
    And user clicks Contact us button
    Then user is navigated to contact us page
    And contact us page is visible successfully
    When user enters "<name>", "<email>", "<subject>" and "<message>"
    And user uploads file
    And user clicks submit button
    And user clicks ok button in alert
    Then success message is apears
    When user clicks home button
    Then user is navigated to the home page
    And home page is visible successfully

    Examples: 
      | name      | email              | subject  | message                     |
      | Kevin Lee | kevinLee@gmail.com | Feedback | Thank you for your website! |
