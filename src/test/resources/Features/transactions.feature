@Transaction
Feature: transactions
  Scenario: Check transactions after deposit
    Given the user is in home page
    When the user is logged in as a customer
    And the deposits a second amount
    Then the transaction history should be accessible