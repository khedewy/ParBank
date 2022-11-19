package testRunner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features/Register.feature",glue = {"steps"},plugin = {"pretty"})
public class RegisterRun extends TestBase {
}
