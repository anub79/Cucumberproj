Feature: Account Page Feature
Background:
Given user has already logged in to application
|username              |password       |
|anagha.ana79@gmail.com|Mypassword$2021|

Scenario:Accounts page title
Given User is on Accounts page
Then user gets the title of the page
And page title should be "My account - My Store"

Scenario: Accounts section count
Given User is on Accounts page 
Then user gets accounts section
|MY ACCOUNT|
|Welcome to your account. Here you can manage all of your personal information and orders.|
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And Accounts section count should be 7