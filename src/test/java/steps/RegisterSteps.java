package steps;

import data.RegisterData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.HomePage;
import pages.RegisterPage;
import tests.TestBase;

import java.io.IOException;

public class RegisterSteps extends TestBase {
    HomePage home;
    RegisterPage register;

    @Given("user in th home page and click register")
    public void user_in_th_home_page_and_click_register() {
        home = new HomePage(driver);
        home.clickRegisterBtn();
    }
    @When("user in the register page and enter his valid data")
    public void user_in_the_register_page_and_enter_his_valid_data() throws IOException, ParseException {
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
    @When("click on register")
    public void click_on_register() {
        register.setRegisterBtn();
    }
    @Then("he make sure that he registered successfully.")
    public void he_make_sure_that_he_registered_successfully() {
        Assert.assertTrue(register.setAssertionMessage().contains("Your account was created successfully. You are now logged in."));

    }
}
