package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;

public class TestRequestLoan extends TestBase{
    HomePage home;
    RegisterPage register;
    RequestLoanPage request;
    HomePageServices services;

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
    public void TestRequestLoan(){
        services = new HomePageServices(driver);
        services.setRequestLoan();
        request = new RequestLoanPage(driver);
        request.setAmountTxt("600");
        request.setDownPaymentTxt("6");
        request.setAmountTxt();
        request.setApplyBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(request.setAssertionMessage(),"We cannot grant a loan in that amount with the given down payment.");
    }
}
