package steps;

import data.RegisterData;
import data.UpdateProfileInformationData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.HomePage;
import pages.RegisterPage;
import pages.UpdateInformationPage;
import tests.TestBase;

import java.io.IOException;
import java.time.Duration;

public class UpdateInforamtionSteps extends TestBase {
    HomePage home;
    RegisterPage register;
    UpdateInformationPage update;
    @Given("User in the th home page and click on register link to register")
    public void user_in_the_th_home_page_and_click_on_register_link_to_register() {
        home = new HomePage(driver);
        home.clickRegisterBtn();
    }
    @When("he enters his personal information and click on register")
    public void he_enters_his_personal_information_and_click_on_register() throws IOException, ParseException {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(register.setAssertionMessage().contains("Your account was created successfully. You are now logged in."));
    }

    @When("click on update profile")
    public void click_on_update_profile() {
        home = new HomePage(driver);
        home.setUpdateInformation();
    }
    @When("enter his new data")
    public void enter_his_new_data() throws IOException, ParseException {
        UpdateProfileInformationData data = new UpdateProfileInformationData();
        data.UpdateData();
        update = new UpdateInformationPage(driver);
        update.setFirstNameTxt(data.firstName);
        update.setLastNameTxt(data.lastName);
        update.setAddressTxt(data.Address);
        update.setCityTxt(data.City);
        update.setStateTxt(data.state);
        update.setZipTxt(data.zip);
        update.setPhoneTxt(data.phone);
    }
    @When("click on Update")
    public void click_on_update() {
        update = new UpdateInformationPage(driver);
        update.setUpdateInfButton();
    }
    @Then("make sure that his information updated")
    public void make_sure_that_his_information_updated() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(update.setAssertionMessage(),"Update Profile");
    }

}
