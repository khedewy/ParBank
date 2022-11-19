package testRunner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features/UpdateProfile.feature",glue = {"steps"})
public class UpdateProfileRun extends TestBase {
}
