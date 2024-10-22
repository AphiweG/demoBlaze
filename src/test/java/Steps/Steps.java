package Steps;

import Pages.CustomerHomePage;
import Pages.CustomerLogin;
import Pages.HomePage;
import Pages.Transactions;
import Utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class Steps {
    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver=browserFactory.startBrowser("chrome","https://www.way2automation.com/angularjs-protractor/banking/#/login/");
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    CustomerLogin customerLogin = PageFactory.initElements(driver, CustomerLogin.class);
    CustomerHomePage customerHomePage = PageFactory.initElements(driver, CustomerHomePage.class);
    Transactions transactions = PageFactory.initElements(driver, Transactions.class);

    @Given("the home page is displayed")
    public void homePageDisplayed() {homePage.homePageDisplay();
    }

    @When("the user logs in as a customer")
    public void userLogsInAsCustomer() {
        homePage.customerLogin();
        customerLogin.verifyCustomerLoginLandingPage();
        customerLogin.clickNameDropdown();
        customerLogin.selectCustomer();
        customerLogin.loginButton();
    }

    @And("the user deposits an amount")
    public void userDepositsAmount() {
        customerHomePage.clickDeposit();
        customerHomePage.enterAmount();
        customerHomePage.clickDepositButton();
    }

    @Then("a success message should be displayed")
    public void successMessageDisplayed() {
        customerHomePage.verifySuccessMessage();
        customerHomePage.logout();
        homePage.returnToHomePage();
    }
    @Given("the home page displayed")
    public void homePageDisplay() {
        homePage.homePageDisplay();
    }

    @When("the user logs in as customer")
    public void userLogsInAsACustomer() {
        homePage.customerLogin();
        customerLogin.verifyCustomerLoginLandingPage();
        customerLogin.clickNameDropdown();
        customerLogin.selectCustomer();
        customerLogin.loginButton();
        customerHomePage.selectAccount(account);
    }

    @And("the user deposits amounts into multiple accounts")
    public void userDepositsAmountsIntoMultipleAccounts() {
        depositAmountForAccount(customerHomePage.firstAccount());
        depositAmountForAccount(customerHomePage.secondAccount());
        depositAmountForAccount(customerHomePage.thirdAccount());
    }
    String account;

    public void depositAmountForAccount(String account) {

        customerHomePage.clickDeposit();
        customerHomePage.enterAmount();
        customerHomePage.clickDepositButton();
        customerHomePage.verifySuccessMessage();
    }
    @Then("success messages should be displayed for each deposit")
    public void successMessageIsDisplayed() {
        customerHomePage.verifySuccessMessage();
        customerHomePage.logout();
        homePage.returnToHomePage();
    }
    @Given("the user is in home page")
    public void homePage() {
        homePage.homePageDisplay();
    }

    @When("the user is logged in as a customer")
    public void userLoggedInAsACustomer() {
        homePage.customerLogin();
        customerLogin.verifyCustomerLoginLandingPage();
        customerLogin.clickNameDropdown();
        customerLogin.selectCustomer();
        customerLogin.loginButton();

    }

    @And("the deposits a second amount")
    public void userDepositsSecondAmount() {
        customerHomePage.clickTransactions();
        transactions.clickRest();
        transactions.clickBackButton();
        customerHomePage.clickDeposit();
        customerHomePage.enterSecondAmount();
        customerHomePage.clickDepositButton();
        customerHomePage.verifySuccessMessage();
    }

    @Then("the transaction history should be accessible")
    public void transactionHistoryIsDisplayed() {
        customerHomePage.clickTransactions();
        transactions.transactionsHomePage();
        transactions.verifyAmountDisplay();
        customerHomePage.logout();

    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
