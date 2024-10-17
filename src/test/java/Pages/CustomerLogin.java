package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerLogin {
    WebDriver driver;

    @FindBy(xpath = "//label[contains(.,'Your Name :')]")
    WebElement customerLanding_xpath;
    @FindBy(xpath = "//select[contains(@id,'userSelect')]")
    WebElement nameDropdown_xpath;
    @FindBy(xpath = "//option[@ng-repeat='cust in Customers'][contains(.,'Hermoine Granger')]")
    WebElement customer_xpath;
    @FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Login')]")
    WebElement loginButton_xpath;

    public void verifyCustomerLoginLandingPage(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(customerLanding_xpath));
        customerLanding_xpath.isDisplayed();
    }
    public void clickNameDropdown() { nameDropdown_xpath.click();}
    public void selectCustomer() { customer_xpath.click();}
    public void loginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(loginButton_xpath));
        loginButton_xpath.click();}
}
