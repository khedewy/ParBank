package testRunner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features/OpnNewAccount.feature",glue = {"steps"})
public class OpenNewAccountRun extends TestBase {
}
