@Deposit
Feature: Deposit
Scenario: Deposit funds for one customer
    Given the home page is displayed
    When the user logs in as a customer
    And the user deposits an amount
    Then a success message should be displayed



