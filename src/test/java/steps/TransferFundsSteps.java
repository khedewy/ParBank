package steps;

import data.RegisterData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.HomePage;
import pages.HomePageServices;
import pages.RegisterPage;
import pages.TransfersPage;
import tests.TestBase;

import java.io.IOException;
import java.time.Duration;

public class TransferFundsSteps extends TestBase {

    HomePage home;
    RegisterPage register;
    TransfersPage transfer;
    HomePageServices services;
    @Given("user in the home page and click on register link")
    public void user_in_the_home_page_and_click_on_register_link() {
        home = new HomePage(driver);
        home.clickRegisterBtn();
    }
    @When("user enter his register data an click")
    public void user_enter_his_register_data_an_click() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.UserData();
        register = new RegisterPage(driver);
        register.setFirstNameTxt(data.firstName);
        register.setLastNameTxt(data.lastName);
        register.setAddressTxt(data.address);
        register.setCityTxt(data.city);
        register.setStateTxt(data.state);
        register.setZipTxt(data.zip);
        register.setPhoneTxt(data.phone);
        register.setSsnTxt(data.ssn);
        register.setUserNameTxt(data.userName);
        register.setPasswordTxt(data.password);
        register.setConfirmPasswordTxt(data.password);
        register.setRegisterBtn();
    }
    @When("click on register and make sure that he registered successfully")
    public void click_on_register_and_make_sure_that_he_registered_successfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        register = new RegisterPage(driver);
        Assert.assertTrue(register.setAssertionMessage().contains("Your account was created successfully. You are now logged in."));
    }
    @When("he click to back to home page")
    public void he_click_to_back_to_home_page() {
        home = new HomePage(driver);
        home.setBackHomePageButton();
    }
    @When("click on transfers funds")
    public void click_on_transfers_funds() {
        services = new HomePageServices(driver);
        services.setTransfersFunds();
    }
    @When("enter the required data")
    public void enter_the_required_data() {
        transfer = new TransfersPage(driver);
        transfer.setTransfersAmount("60");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        transfer.setFromAccount();
        transfer.setToAccount();
    }
    @When("click on transfer")
    public void click_on_transfer() {
        transfer = new TransfersPage(driver);
        transfer.setTransfersButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(transfer.setAssertionMessage()," has been transferred from account #");

    }

}
