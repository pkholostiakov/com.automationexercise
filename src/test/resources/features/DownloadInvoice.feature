Feature: test download ivoice functionalities

  Scenario: download Invoice after purchase order
    When browser is open
    And user is on the home page
    And home page is visible successfully
    When user clicks add to cart button on the item
    And user clicks continue shopping button
    And user clicks view cart button
    Then user is navigated to view cart page
    And view cart page is visible successfully
    And user verify all the products in the cart
    When user clicks proceed to checkout button
    And user clicks register login button
    Then user is navigated to login page
    And login page is visible successfully
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
    And user clicks view cart button
    Then user is navigated to view cart page
    And view cart page is visible successfully
    And user verify all the products in the cart
    When user clicks proceed to checkout button
    And user is navigated to checkout page
    And checkout page is visible successfully
    And delivery address and user info is matches
    When user enters discription in comment text area
    And user clicks place order button
    And user is navigated to payment page
    And payment page is visible successfully
    When user enters name on card, card number, CVC and expiration date
    And user clicks pay and confirm order button
    And user is navigated to payment done page
    And payment done page is visible successfully
    And order placed message is appears
    When user clicks download invoice button
    Then invoice is downloaded
