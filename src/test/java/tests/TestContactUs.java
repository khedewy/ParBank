package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.time.Duration;

public class TestContactUs extends TestBase{
    HomePage home;
    ContactUsPage contact;

    @Test
    public void GoToContactUsPage(){
        home = new HomePage(driver);
        home.setContactUs();
    }
    @Test(priority = 1)
    public void UserCanContactUs(){
        contact = new ContactUsPage(driver);
        contact.setNameTxt("mahmoud");
        contact.setEmailTxt("zaqw@gmail.com");
        contact.setPhoneTxt("0987612321");
        contact.setMessageBox("please confirm this message.");
        contact.setSendButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(contact.setAssertionMessage().contains("A Customer Care Representative will be contacting you."));
    }
}
