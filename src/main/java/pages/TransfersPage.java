package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransfersPage extends PageBase{
    public TransfersPage(WebDriver driver) {
        super(driver);
    }
    private final By TransfersAmount = By.id("amount");
    private final By fromAccount = By.id("fromAccountId");
    private final By toAccount = By.id("toAccountId");
    private final By transfersButton = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[2]/input");
    private final By assertionMessage = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/p[1]");

    public void setTransfersAmount(String amount){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(TransfersAmount)));
        driver.findElement(TransfersAmount).sendKeys(amount);
    }

    public void setFromAccount(){
        select = new Select(driver.findElement(fromAccount));
        select.selectByIndex(0);
    }
    public void setToAccount(){
        select = new Select(driver.findElement(toAccount));
        select.selectByIndex(0);
    }

    public void setTransfersButton(){
        driver.findElement(transfersButton).click();
    }

    public String setAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }
}
