package testRunner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features/ContactUs.feature",glue = {"steps"})
public class ContactUsRun extends TestBase {
}
