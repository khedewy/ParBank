package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BillPayPage extends PageBase{
    public BillPayPage(WebDriver driver) {
        super(driver);
    }
    private final By paymentName = By.name("payee.name");
    private final By paymentAddress = By.name("payee.address.street");
    private final By paymentCity = By.name("payee.address.city");
    private final By paymentState = By.name("payee.address.state");
    private final By paymentZipCode = By.name("payee.address.zipCode");
    private final By paymentPhone = By.name("payee.phoneNumber");
    private final By paymentAccount = By.name("payee.accountNumber");
    private final By paymentVerifyAccount = By.name("verifyAccount");
    private final By paymentAmount = By.name("amount");
    private final By fromAccountId = By.name("fromAccountId");
    private final By sendButton = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[14]/td[2]/input");
    private final By AssertionMessage = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/p[2]");

    public void setPaymentName(String name){
        driver.findElement(paymentName).sendKeys(name);
    }
    public void setPaymentAddress(String address){
        driver.findElement(paymentAddress).sendKeys(address);
    }
    public void setPaymentCity(String city){
        driver.findElement(paymentCity).sendKeys(city);
    }
    public void setPaymentState(String state){
        driver.findElement(paymentState).sendKeys(state);
    }
    public void setPaymentZipCode(String zip){
        driver.findElement(paymentZipCode).sendKeys(zip);
    }
    public void setPaymentPhone(String phone){
        driver.findElement(paymentPhone).sendKeys(phone);
    }
    public void setPaymentAccount(String account){
        driver.findElement(paymentAccount).sendKeys(account);
    }
    public void setPaymentVerifyAccount(String verify){
        driver.findElement(paymentVerifyAccount).sendKeys(verify);
    }
    public void setPaymentAmount(String amount){
        driver.findElement(paymentAmount).sendKeys(amount);
    }
    public void setFromAccountId(){
        select = new Select(driver.findElement(fromAccountId));
        select.selectByIndex(0);
    }
    public void setSendButton(){
        driver.findElement(sendButton).click();
    }
    public String setAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }
}
