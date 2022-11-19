package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenNewAccountPage extends PageBase{
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    private final By typeOfAccount = By.id("type");
    private final By accountId = By.id("fromAccountId");
    private final By createButton = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div/input");
    private final By assertionMessage = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/p[1]");

    public void setTypeOfAccount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(typeOfAccount)));
        select = new Select(driver.findElement(typeOfAccount));
        select.selectByIndex(1);
    }

    public void setAccountId(){
        select = new Select(driver.findElement(accountId));
        select.selectByIndex(0);
    }

    public void setCreateButton(){
        driver.findElement(createButton).click();
    }

    public String setAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }
}
