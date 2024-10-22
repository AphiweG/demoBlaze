package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;

public class Transactions {
    WebDriver driver;
    @FindBy(xpath = "//button[@ng-show='showDate'][contains(.,'Reset')]")
    WebElement reset_xpath;
    @FindBy(xpath = "(//div[contains(@ng-show,'showDate')])[1]")
    WebElement transactionsHome_xpath;
    @FindBy(xpath = "//button[@class='btn'][contains(.,'Back')]")
    WebElement backButton_xpath;
    @FindBy(xpath = "//td[contains(.,'31459')]")
    WebElement verifyAmountDisplay_xpath;
    public Transactions(WebDriver driver){
        this.driver=driver;
    }
    public void transactionsHomePage(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(transactionsHome_xpath));
        transactionsHome_xpath.isDisplayed();}
    public void clickRest(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(reset_xpath));
        reset_xpath.click();}
    public void clickBackButton(){
        backButton_xpath.click();
    }
    public void verifyAmountDisplay(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(verifyAmountDisplay_xpath));
        verifyAmountDisplay_xpath.isDisplayed();}

}
