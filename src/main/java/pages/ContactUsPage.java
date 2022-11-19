package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    private final By nameTxt = By.id("name");
    private final By emailTxt = By.id("email");
    private final By phoneTxt = By.id("phone");
    private final By messageBox = By.id("message");
    private final By sendButton = By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/input");
    private final By assertionMessage = By.xpath("/html/body/div[1]/div[3]/div[2]/p[2]");

    public void setNameTxt(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
        driver.findElement(nameTxt).sendKeys(name);
    }
    public void setEmailTxt(String email){
        driver.findElement(emailTxt).sendKeys(email);
    }
    public void setPhoneTxt(String phone){
        driver.findElement(phoneTxt).sendKeys(phone);
    }
    public void setMessageBox(String message){
        driver.findElement(messageBox).sendKeys(message);
    }
    public void setSendButton(){
        driver.findElement(sendButton).click();
    }
    public String setAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }
}
