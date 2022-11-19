package tests;

import data.BillData;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BillPayPage;
import pages.HomePage;
import pages.HomePageServices;
import pages.RegisterPage;

import java.io.IOException;
import java.time.Duration;

public class TestBillInformation extends TestBase{
    HomePage home;
    RegisterPage register;
    HomePageServices services;
    BillPayPage bill;
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
    public void TestBillInformation() throws IOException, ParseException{
        BillData data = new BillData();
        data.BillData();
        services = new HomePageServices(driver);
        services.setBillPay();
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
        bill.setSendButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(bill.setAssertionMessage().contains("See Account Activity for more details."));
    }
}
