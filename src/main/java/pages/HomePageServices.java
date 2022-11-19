package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageServices extends PageBase{
    public HomePageServices(WebDriver driver) {
        super(driver);
    }

    private final By transfersFunds = By.linkText("Transfer Funds");

    private final By requestLoan = By.linkText("Request Loan");

    private final By billPay = By.linkText("Bill Pay");

    private final By accountOverview = By.linkText("Accounts Overview");

    private final By openNewAccount = By.linkText("Open New Account");

    public TransfersPage setTransfersFunds(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(transfersFunds)));
        driver.findElement(transfersFunds).click();
        return new TransfersPage(driver);
    }

    public RequestLoanPage setRequestLoan(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(requestLoan)));
        driver.findElement(requestLoan).click();
        return new RequestLoanPage(driver);
    }

    public BillPayPage setBillPay(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(billPay)));
        driver.findElement(billPay).click();
        return new BillPayPage(driver);
    }

    public void setAccountOverview(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(accountOverview)));
        driver.findElement(accountOverview).click();
    }

    public OpenNewAccountPage setOpenNewAccount(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(openNewAccount)));
        driver.findElement(openNewAccount).click();
        return new OpenNewAccountPage(driver);
    }





}

