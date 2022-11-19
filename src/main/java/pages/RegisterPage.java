package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameTxt = By.id("customer.firstName");
    private final By lastNameTxt = By.id("customer.lastName");
    private final By addressTxt = By.id("customer.address.street");
    private final By cityTxt = By.id("customer.address.city");
    private final By stateTxt = By.id("customer.address.state");
    private final By zipTxt = By.id("customer.address.zipCode");
    private final By phoneTxt = By.id("customer.phoneNumber");
    private final By ssnTxt = By.id("customer.ssn");
    private final By userNameTxt = By.id("customer.username");
    private final By passwordTxt = By.id("customer.password");
    private final By confirmPasswordTxt = By.id("repeatedPassword");
    private final By registerBtn = By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input");
    private final By assertionMessage =By.xpath("/html/body/div[1]/div[3]/div[2]/p");

    public void setFirstNameTxt(String firstName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstNameTxt)));
        driver.findElement(firstNameTxt).sendKeys(firstName);
    }

    public void setLastNameTxt(String lastName){
        driver.findElement(lastNameTxt).sendKeys(lastName);
    }

    public void setAddressTxt(String address){
        driver.findElement(addressTxt).sendKeys(address);
    }

    public void setCityTxt(String city){
        driver.findElement(cityTxt).sendKeys(city);
    }

    public void setStateTxt(String state){
        driver.findElement(stateTxt).sendKeys(state);
    }

    public void setZipTxt(String zip){
        driver.findElement(zipTxt).sendKeys(zip);
    }
    public void setPhoneTxt(String phone){
        driver.findElement(phoneTxt).sendKeys(phone);
    }
    public void setSsnTxt(String ssn){
        driver.findElement(ssnTxt).sendKeys(ssn);
    }
    public void setUserNameTxt(String userName){
        driver.findElement(userNameTxt).sendKeys(userName);
    }
    public void setPasswordTxt(String password){
        driver.findElement(passwordTxt).sendKeys(password);
    }
    public void setConfirmPasswordTxt(String password){
        driver.findElement(confirmPasswordTxt).sendKeys(password);
    }

    public void setRegisterBtn(){
        driver.findElement(registerBtn).click();
    }

    public String setAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }
}
