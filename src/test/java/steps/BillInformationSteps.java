package steps;

import data.BillData;
import data.RegisterData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.BillPayPage;
import pages.HomePage;
import pages.HomePageServices;
import pages.RegisterPage;
import tests.TestBase;

import java.io.IOException;
import java.time.Duration;

public class BillInformationSteps extends TestBase {
    HomePage home;
    RegisterPage register;
    HomePageServices services;
    BillPayPage bill;
    @Given("User in the home page in click on register")
    public void user_in_the_home_page_in_click_on_register() {
        home = new HomePage(driver);
        home.clickRegisterBtn();
    }
    @When("User in register page and enter his data")
    public void user_in_register_page_and_enter_his_data() throws IOException, ParseException {
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
        home = new HomePage(driver);
        home.setBackHomePageButton();
    }
    @When("user is sur that he registered successfully")
    public void user_is_sur_that_he_registered_successfully() {
        register = new RegisterPage(driver);
        Assert.assertEquals(register.setAssertionMessage(),"READ MORE");
        home = new HomePage(driver);
        home.setBackHomePageButton();
    }
    @When("click on bill services button")
    public void click_on_bill_services_button() {
        services = new HomePageServices(driver);
        services.setBillPay();
    }
    @When("he fills his information")
    public void he_fills_his_information() throws IOException, ParseException {
        BillData data = new BillData();
        data.BillData();
        bill = new BillPayPage(driver);
        bill.setPaymentName(data.Name);
        bill.setPaymentAddress(data.Address);
        bill.setPaymentCity(data.City);
        bill.setPaymentState(data.State);
        bill.setPaymentZipCode(data.Zip);
        bill.setPaymentAccount(data.Account);
        bill.setPaymentVerifyAccount(data.Account);
        bill.setPaymentPhone(data.Phone);
        bill.setPaymentAmount(data.Amount);
        bill.setFromAccountId();
    }
    @When("click on send button")
    public void click_on_send_button() {
        bill = new BillPayPage(driver);
        bill.setSendButton();
    }
    @Then("make sure that he used the service successfully")
    public void make_sure_that_he_used_the_service_successfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(bill.setAssertionMessage(),"");
    }

}
