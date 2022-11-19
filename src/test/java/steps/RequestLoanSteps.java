package steps;

import data.RegisterData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.HomePage;
import pages.HomePageServices;
import pages.RegisterPage;
import pages.RequestLoanPage;
import tests.TestBase;

import java.io.IOException;
import java.time.Duration;

public class RequestLoanSteps extends TestBase {
   HomePage home;
   RegisterPage register;
   RequestLoanPage request;
   HomePageServices services;
   @Given("user in the home page and he click on register as a first step")
   public void user_in_the_home_page_and_he_click_on_register_as_a_first_step() {
      home = new HomePage(driver);
      home.clickRegisterBtn();
   }
   @When("the user enter his data")
   public void the_user_enter_his_data() throws IOException, ParseException {
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
   @When("click to back to home page")
   public void click_to_back_to_home_page() {
      home = new HomePage(driver);
      home.setBackHomePageButton();
   }
   @When("click on request loan")
   public void click_on_request_loan() {
      services = new HomePageServices(driver);
      services.setRequestLoan();
   }
   @When("fill the requirements")
   public void fill_the_requirements() {
      request = new RequestLoanPage(driver);
      request.setAmountTxt("600");
      request.setDownPaymentTxt("6");
      request.setAmountTxt();
   }
   @When("click on apply")
   public void click_on_apply() {
      request = new RequestLoanPage(driver);
      request.setApplyBtn();
   }
   @Then("make sure that he applied successfully")
   public void make_sure_that_he_applied_successfully() {
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      Assert.assertEquals(request.setAssertionMessage(),"Congratulations, your loan has been approved.");
   }

   }
