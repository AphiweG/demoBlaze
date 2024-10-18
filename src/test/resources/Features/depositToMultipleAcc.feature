@Deposits
Feature: Deposit To Multiple Acc
  Scenario: Deposit funds for multiple accounts
    Given the home page displayed
    When the user logs in as customer
    And the user deposits amounts into multiple accounts
    Then success messages should be displayed for each deposit