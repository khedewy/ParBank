package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import tests.TestBase;

import java.time.Duration;

public class ContactUsSteps extends TestBase {
    HomePage home;
    ContactUsPage contact;
    @Given("user in the home page an click on contact us")
    public void user_in_the_home_page_an_click_on_contact_us() {
        home = new HomePage(driver);
        home.setContactUs();
    }
    @When("he enter his information")
    public void he_enter_his_information() {
        contact = new ContactUsPage(driver);
        contact.setNameTxt("mahmoud");
        contact.setEmailTxt("zaqw@gmail.com");
        contact.setPhoneTxt("0987612321");
        contact.setMessageBox("please confirm this message.");
        contact.setSendButton();
    }
    @Then("make sure that his message sent successfully")
    public void make_sure_that_his_message_sent_successfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(contact.setAssertionMessage().contains("A Customer Care Representative will be contacting you."));
    }
}
