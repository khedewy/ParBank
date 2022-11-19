package steps;

import data.RegisterData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.HomePage;
import pages.HomePageServices;
import pages.OpenNewAccountPage;
import pages.RegisterPage;
import tests.TestBase;

import java.io.IOException;
import java.time.Duration;

public class OpenNewAccountSteps extends TestBase {
    HomePage home;
    RegisterPage register;
    HomePageServices services;
    OpenNewAccountPage newAccount;

    @Given("User in the home page an click on register to make the registration first")
    public void user_in_the_home_page_an_click_on_register_to_make_the_registration_first() {
        home = new HomePage(driver);
        home.clickRegisterBtn();
           }

    @When("He enter his registration data")
    public void he_enter_his_registration_data() throws IOException, ParseException {
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
    }
    @When("click on register button to register")
    public void click_on_register_button_to_register() {
        register = new RegisterPage(driver);
        register.setRegisterBtn();
    }
    @When("make sure that he registered successfully")
    public void make_sure_that_he_registered_successfully() {
        register = new RegisterPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(register.setAssertionMessage(),"Your account was created successfully. You are now logged in.");
    }
    @When("Back to home page and click on open new account")
    public void back_to_home_page_and_click_on_open_new_account() {
        home = new HomePage(driver);
        home.setBackHomePageButton();
        services = new HomePageServices(driver);
        services.setOpenNewAccount();
    }
    @When("fill his new account data")
    public void fill_his_new_account_data() {
        newAccount = new OpenNewAccountPage(driver);
        newAccount.setTypeOfAccount();
        newAccount.setAccountId();
    }
    @When("click on open new account")
    public void click_on_open_new_account() {
        newAccount = new OpenNewAccountPage(driver);
        newAccount.setCreateButton();
    }
    @Then("he makes sure that he opened his new account successfully")
    public void he_makes_sure_that_he_opened_his_new_account_successfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(newAccount.setAssertionMessage().contains("Congratulations, your account is now open."));
    }
}
