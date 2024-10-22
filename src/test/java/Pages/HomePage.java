package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "//button[@class='btn home'][contains(.,'Home')]")
    WebElement homepage_xpath;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg'][contains(.,'Customer Login')]")
    WebElement customerLogin_xpath;
    @FindBy(xpath = "//button[contains(@class,'btn home')]")
    WebElement returnToHomePage_xpath;

    public void homePageDisplay(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homepage_xpath));
        homepage_xpath.isDisplayed();}
    public void customerLogin(){customerLogin_xpath.click();}
    public void returnToHomePage(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(returnToHomePage_xpath));
        returnToHomePage_xpath.click();}
}

