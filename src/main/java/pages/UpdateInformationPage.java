package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateInformationPage extends PageBase{
    public UpdateInformationPage(WebDriver driver) {
        super(driver);
    }
    private final By firstNameTxt = By.id("customer.firstName");
    private final By lastNameTxt = By.id("customer.lastName");
    private final By addressTxt = By.id("customer.address.street");
    private final By cityTxt = By.id("customer.address.city");
    private final By stateTxt = By.id("customer.address.state");
    private final By zipTxt = By.id("customer.address.zipCode");
    private final By phoneTxt = By.id("customer.phoneNumber");

    private final By assertionMessage = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1");

    private final By updateInfButton = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/table/tbody/tr[8]/td[2]/input");

    public void setFirstNameTxt(String firstName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstNameTxt)));
        driver.findElement(firstNameTxt).clear();
        driver.findElement(firstNameTxt).sendKeys(firstName);
    }

    public void setLastNameTxt(String lastName){
        driver.findElement(lastNameTxt).clear();
        driver.findElement(lastNameTxt).sendKeys(lastName);
    }

    public void setAddressTxt(String address){
        driver.findElement(addressTxt).clear();
        driver.findElement(addressTxt).sendKeys(address);
    }

    public void setCityTxt(String city){
        driver.findElement(cityTxt).clear();
        driver.findElement(cityTxt).sendKeys(city);
    }

    public void setStateTxt(String state){
        driver.findElement(stateTxt).clear();
        driver.findElement(stateTxt).sendKeys(state);
    }

    public void setZipTxt(String zip){
        driver.findElement(zipTxt).clear();
        driver.findElement(zipTxt).sendKeys(zip);
    }
    public void setPhoneTxt(String phone){
        driver.findElement(phoneTxt).clear();
        driver.findElement(phoneTxt).sendKeys(phone);
    }

    public void setUpdateInfButton(){
        driver.findElement(updateInfButton).click();
    }

    public String setAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }
}
