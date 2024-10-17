package Steps;

import Pages.CustomerHomePage;
import Pages.CustomerLogin;
import Pages.HomePage;
import Utils.BrowserFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class Steps {
    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver=browserFactory.startBrowser("chrome","https://www.way2automation.com/angularjs-protractor/banking/#/login/");
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    CustomerLogin customerLogin = PageFactory.initElements(driver, CustomerLogin.class);
    CustomerHomePage customerHomePage = PageFactory.initElements(driver, CustomerHomePage.class);

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

    @When("the user deposits amount")
    public void userDepositsAmount() {
        customerHomePage.clickDeposit();
        customerHomePage.enterAmount();
        customerHomePage.clickDepositButton();
    }

    @Then("a success message should be displayed")
    public void successMessageDisplayed() {
        assertTrue(customerHomePage.verifySuccessMessage());
        customerHomePage.logout();
        homePage.returnToHomePage();
    }

    @Given("the user deposits amounts into multiple accounts")
    public void userDepositsAmountsIntoMultipleAccounts() {
        homePage.homePageDisplay();
        homePage.customerLogin();
        customerLogin.verifyCustomerLoginLandingPage();
        customerLogin.clickNameDropdown();
        customerLogin.selectCustomer();
        customerLogin.loginButton();
    }
    @When("the user deposits an amount")
    public void userDepositsAmountInMultipleAcc() {
        customerHomePage.selectAccount();
        customerHomePage.firstAccount();
        customerHomePage.clickDeposit();
        customerHomePage.enterAmount();
        customerHomePage.clickDepositButton();
        customerHomePage.verifySuccessMessage();
        customerHomePage.selectAccount();
        customerHomePage.secondAccount();
        customerHomePage.clickDeposit();
        customerHomePage.enterAmount();
        customerHomePage.clickDepositButton();
        customerHomePage.verifySuccessMessage();
        customerHomePage.selectAccount();
        customerHomePage.thirdAccount();
        customerHomePage.clickDeposit();
        customerHomePage.enterAmount();
        customerHomePage.clickDepositButton();
    }
    @Then("a success message must be displayed")
    public void successMessageDisplay() {
        assertTrue(customerHomePage.verifySuccessMessage());
        customerHomePage.logout();
        homePage.returnToHomePage();
    }

    @When("the user deposits a second amount")
    public void userDepositsSecondAmount() {
        customerHomePage.selectAccount();
        customerHomePage.firstAccount();
        customerHomePage.clickDeposit();
        customerHomePage.enterSecondAmount(); // Define this method in your page object
        customerHomePage.clickDepositButton();
        assertTrue(customerHomePage.verifySuccessMessage());
        customerHomePage.clickTransactions();
    }
}
