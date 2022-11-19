package testRunner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features/BillInformation.feature",glue = {"steps"})
public class BillIServiceRun extends TestBase {
}
