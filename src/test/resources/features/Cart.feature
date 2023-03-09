Feature: test cart functionalities

  Background: 
    When browser is open
    And user is on the home page
    And home page is visible successfully

  Scenario: add products in cart
    And user clicks Products button
    Then user is navigated to Products page
    And products page is visible successfully
    When user clicks add to cart button on the item
    And user clicks continue shopping button
    And user clicks view cart button
    Then user is navigated to view cart page
    And view cart page is visible successfully
    And user verify all the products in the cart

  Scenario: verify product quantity in cart
    When user clicks on the product from the product list
    Then user is navigated to the Product Details page
    And product details page is visible successfully
    When user increases quantity
    And user clicks add to cart button near the quantity
    And user clicks continue shopping button
    And user clicks view cart button
    Then user is navigated to view cart page
    And view cart page is visible successfully
    And user verify all the products in the cart

  Scenario: add to cart from recomended items
    And user clicks add to cart button on recommended product
    And user clicks continue shopping button
    And user clicks view cart button
    Then user is navigated to view cart page
    And view cart page is visible successfully
    And user verify all the products in the cart

  Scenario: remove products from cart
    When user clicks add to cart button on the item
    And user clicks continue shopping button
    When user clicks add to cart button on the item
    And user clicks continue shopping button
    And user clicks view cart button
    Then user is navigated to view cart page
    And view cart page is visible successfully
    And user verify all the products in the cart
    When user clicks remove button in the cart
    And user verify all the products in the cart
