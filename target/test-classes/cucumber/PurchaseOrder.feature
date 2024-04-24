
@tag
Feature: Purchase the order from Ecommarce Website
  I want to use this template for my feature file
 Background: 
 Given I landed on Ecommerce page
  @tag1
  Scenario Outline: Positive test of submitting order
  Given Logged in with Username<name> and Password<password>
  When I add product <productName> to cart
  And Checkout <productName> and submit the order
  Then "THANKYOU FOR THE ORDER." message is displayed on the confirmationPage 
  
    Examples: 
    |name                 | password     | productName     |
    |mishraji@gmail.com   | Smneeraj8@   |ADIDAS ORIGINAL  |
    

