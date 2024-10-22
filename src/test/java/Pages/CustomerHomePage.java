package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerHomePage {
    WebDriver driver;
    @FindBy(xpath = "//button[@ng-class='btnClass2'][contains(.,'Deposit')]")
    WebElement depositButton_xpath;
    @FindBy(xpath = "//input[@type='number']")
    WebElement amount_xpath;
    @FindBy(xpath = "//button[@type='submit'][contains(.,'Deposit')]")
    WebElement deposit;
    @FindBy(xpath = "//span[@class='error ng-binding'][contains(.,'Deposit Successful')]")
    WebElement successMessage_xpath;
    @FindBy(xpath = "//button[contains(.,'Logout')]")
    WebElement logoutButton_xpath;
    @FindBy(xpath = "//select[contains(@id,'accountSelect')]")
    WebElement selectAcc_xpath;
    @FindBy(xpath = "//option[@label='1002'][contains(.,'1002')]")
    WebElement secondAcc_xpath;
    @FindBy(xpath = "//option[@label='1003'][contains(.,'1003')]")
    WebElement thirdAcc_xpath;
    @FindBy(xpath = "//option[@label='1001'][contains(.,'1001')]")
    WebElement firstAcc_xpath;
    @FindBy(xpath = "//button[contains(.,'Transactions')]")
    WebElement transactions_xpath;


    public void clickDeposit(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(depositButton_xpath));
        depositButton_xpath.click();
    }

    public void enterAmount(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(amount_xpath));
        amount_xpath.sendKeys("1500");}
    public void enterSecondAmount(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(amount_xpath));
        amount_xpath.sendKeys("31459");}
    public void clickDepositButton(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(deposit));
        deposit.click();}
    public boolean verifySuccessMessage(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(successMessage_xpath));
        successMessage_xpath.isDisplayed();
        return false;
    }
    public void logout(){logoutButton_xpath.click();}
    public void selectAccount(String account){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(selectAcc_xpath));
        selectAcc_xpath.click();}
    public String secondAccount(){secondAcc_xpath.click();
        return null;
    }
    public String thirdAccount(){thirdAcc_xpath.click();
        return null;
    }
    public String firstAccount(){firstAcc_xpath.click();

        return null;
    }
    public void clickTransactions(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(transactions_xpath));
        transactions_xpath.click();}







}
