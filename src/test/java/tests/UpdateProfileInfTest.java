package tests;

import data.RegisterData;
import data.UpdateProfileInformationData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.UpdateInformationPage;

import java.io.IOException;
import java.time.Duration;

public class UpdateProfileInfTest extends TestBase{
    HomePage home;
    RegisterPage register;
    UpdateInformationPage update;


    @Test
    public void goToRegisterPage(){
        home = new HomePage(driver);
        home.clickRegisterBtn();
    }
    @Test(priority = 1)
    public void UserCanRegister() throws IOException, ParseException {
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
        Assert.assertTrue(register.setAssertionMessage().contains("Your account was created successfully. You are now logged in."));
    }
    @Test(priority = 2)
    public void UserCanUpdateINf() throws IOException, ParseException {
        UpdateProfileInformationData data = new UpdateProfileInformationData();
        data.UpdateData();
        home = new HomePage(driver);
        home.setUpdateInformation();
        update = new UpdateInformationPage(driver);
        update.setFirstNameTxt(data.firstName);
        update.setLastNameTxt(data.lastName);
        update.setAddressTxt(data.Address);
        update.setCityTxt(data.City);
        update.setStateTxt(data.state);
        update.setZipTxt(data.zip);
        update.setPhoneTxt(data.phone);
        update.setUpdateInfButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(update.setAssertionMessage(),"Update Profile");
    }

}
