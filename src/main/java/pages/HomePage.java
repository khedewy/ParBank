package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By registerBtn = By.linkText("Register");
    private final By updateProfileInformation =By.linkText("Update Contact Info");
    private final By BackHomePageButton = By.linkText("home");
    private final By contactUs = By.linkText("Contact Us");

    public RegisterPage clickRegisterBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(registerBtn)));
        driver.findElement(registerBtn).click();
        return new RegisterPage(driver);
    }

    public UpdateInformationPage setUpdateInformation(){
        driver.findElement(updateProfileInformation).click();
        return new UpdateInformationPage(driver);
    }

    public void setBackHomePageButton(){
        driver.findElement(BackHomePageButton).click();
    }

    public ContactUsPage setContactUs(){
        driver.findElement(contactUs).click();
        return new ContactUsPage(driver);
    }
}
