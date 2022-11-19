package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.osgl.util.Str;

import java.time.Duration;

public class RequestLoanPage extends PageBase{
    public RequestLoanPage(WebDriver driver) {
        super(driver);
    }

    private final By amountTxt = By.id("amount");
    private final By downPaymentTxt = By.id("downPayment");
    private final By fromAccount = By.id("fromAccountId");
    private final By applyBtn = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/table/tbody/tr[4]/td[2]/input");
    private final By assertionMessage = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div/p");

    public void setAmountTxt(String amount){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(amountTxt)));
        driver.findElement(amountTxt).sendKeys(amount);
    }

    public void setDownPaymentTxt(String downPayment){
        driver.findElement(downPaymentTxt).sendKeys(downPayment);
    }
    public void setAmountTxt(){
        select = new Select(driver.findElement(fromAccount));
        select.selectByIndex(0);
    }
    public void setApplyBtn(){
        driver.findElement(applyBtn).click();
    }
    public String setAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }
}
