package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HomePageServices;
import pages.OpenNewAccountPage;
import pages.RegisterPage;

import java.io.IOException;
import java.time.Duration;

public class TestOpenNewAccount extends TestBase{
    HomePage home;
    RegisterPage register;
    HomePageServices services;
    OpenNewAccountPage newAccount;

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
        home = new HomePage(driver);
        home.setBackHomePageButton();
    }
    @Test(priority = 2)
    public void testOpenMewAccount(){
        services = new HomePageServices(driver);
        services.setOpenNewAccount();
        newAccount = new OpenNewAccountPage(driver);
        newAccount.setTypeOfAccount();
        newAccount.setAccountId();
        newAccount.setCreateButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(newAccount.setAssertionMessage().contains("Congratulations, your account is now open."));
    }
}
