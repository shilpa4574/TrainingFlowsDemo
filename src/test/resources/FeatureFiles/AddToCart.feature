Feature: To Login amazon account and add a product to cart

@P2
Scenario: User search product in amazon account
Given A user is logged in amazon accoount
When he searches for a product
Then the search result is verified
And account is signedout
@P1
Scenario: Add product to cart and logout the account
Given User login to amazon account
When  A product is searched
Then  product is added to cart 
And verify the cart has the product 
Then delete the product and verify the entry is removed
And logout the account

@P2
Scenario: Add new address 
Given User is logged in amazon account
When Your address section in my account is selected
Then add new address and verify
And Signout the account
