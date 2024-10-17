Feature: transactions
Scenario: Check transactions after deposit
Given the home page is displayed
When the user logs in as a customer
And the user deposits a second amount
Then the transaction history should be accessible